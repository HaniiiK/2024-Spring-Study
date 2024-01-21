package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.inject.Provider;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypBean1 = ac.getBean(PrototypeBean.class);

        prototypBean1.addCount();
        assertThat(prototypBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypBean2 = ac.getBean(PrototypeBean.class);
        prototypBean2.addCount();
        assertThat(prototypBean2.getCount()).isEqualTo(1);

    }

    @Test
    void singletonClientUsePrototype(){
                AnnotationConfigApplicationContext ac =
                        new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);
        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1);
    }

    @Scope("singleton")
    static class ClientBean {
//        private final PrototypeBean prototypeBean;
        //스프링빈이 등록되면서 프로토타입빈도 같이 등록된다. 생성시점에 주입됨.  이때 프로토타입 빈이 만들어져서 등록되버림.

        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider;

//        @Autowired
//        public ClientBean(PrototypeBean prototypeBean){
//            this.prototypeBean =prototypeBean;
//        }
        public  int logic(){
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            //생성시점에 주입된 프로토타입을 사용한다.
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }

    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            // 나의 참조값 볼 수 있음
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBewan.destroy");
        }

    }
}
