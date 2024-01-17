package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //(우리가 만들었던 순수한 di컨테이너가 가진 문제점을 확인하는 과정-> 나중에 스프링과 비교할 예정)
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        //참조 값이 다른지 확인해보자
        //조회: 호출할 때 마다 객체를 생성 하는가? yes
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //1과 2는 달라야한다
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    public static void main(String[] args) {
        //SingletonService singletonService = new SingletonService(); -> privated이라서 못 만든다. 컴파일 오류!
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService SingletonService1 = SingletonService.getInstance(); //직접 싱글톤SingletonService 만들어서 싱글톤을 적용시켰다
        SingletonService SingletonService2 = SingletonService.getInstance();
    // 같은 인스턴스이다.같은 참조값을 가진다.  SingletonService1& SingletonService2
        //jvm 실행할 때 생성되는 동일 값의 인스턴스를 가진다.
        System.out.println("SingletonService1 = " + SingletonService1);
        System.out.println("SingletonService2 = " + SingletonService2);
        assertThat(SingletonService1).isSameAs(SingletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        //14line의 순수한 자바 DI 컨테이너와 비교
        //AppConfig appConfig = new AppConfig(); ->   호출할 때 마다 객체를 생성 하는가? ->yes

        //스프링 컨테이너를 이용한 싱글톤 ->  호출할 때 마다 다른 스객체를 생성 하는가? ->x
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. 조회: 호출할 때 마다 객체를 생성 하는가? (우리가 만들었던 순수한 di컨테이너가 가진 문제점을 확인하는 과정-> 나중에 스프링과 비교할 예정)
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        //2. 조회: 호출할 때 마다 객체를 생성 하는가?
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //스프링 컨테이너를 이용한 싱글톤 ->  호출할 때 마다 다른 스객체를 생성 하는가? ->x
        assertThat(memberService1).isEqualTo(memberService2);
    }
}


