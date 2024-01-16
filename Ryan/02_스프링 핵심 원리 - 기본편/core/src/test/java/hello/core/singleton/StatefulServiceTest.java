package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingletone() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        //A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);
//       Service1, Service2 둘 다 같은 인스턴스 사용하고 있어서 20000원 나온다 (하나의 필드에 값을 넣고 있어서 나중에 입력한 값이 들어가게된다.)

        //ThreadA: 사용자A 주문 금액 조회
        //   int price = statefulService1.getPrice();
        // System.out.println("price = " + price); // -> 10000원 나온다
        //statefulService1 와 statefulService2눈 참조값 까지 같은 인스턴스
        //StatefulService.class stateless되게 설계하면 에러 방지 가능
        assertThat(userAPrice).isEqualTo(10000);

    }


    //테스트
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}