package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//애플리케이션 환경 설정
//-> Configuratin, Bean 어노테이션 이용! 의존성주입 DI를 이용하면  MemberSerciceImpl에서 MemoryMemberRepository구현체를 사욜할 수 있다.( 생성자를 통해서 멤버변수에 값을 할당받음)

//AppConfig가 MemberServiceImpl과 MemoryMemberRepository 둘 다 생성한다.
//객체의 생성과 연결을 담당한다 -> DIP 완성! (이제는 MemberServiceImpl은 추상에만 의존하면 된다.)
//객체를 생성하고  연결하는 역할(by AppConfig), 실행하는 역할 (MemberServiceImpl) 이렇게 분리된다.
@Configuration
public class AppConfig_sub {


    // Bean 어노테이션 -> return 객체를 스프링 컨테이너에 등록. 등록된 객체를 스프링빈이라고 한다.
    //생성자를 통해서 new인스턴스 생성된것을 (구현체)를 주입  = 생성자를 통해 주입
    //AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
    // MemberServiceImpl의 인스턴스를 생성(new)하여 반환하고= 구현객체!
    //memberService() 메서드
    //MemberService 인터페이스를 반환한다.
    @Bean
    public MemberService memberService() {
        //MemberServiceImpl 사용 하는 곳에서는 new MemoryMemberRepository() = 구현체 이걸 사용하고 있다!
        //new MemberServiceImpl(): 구현체 생성하면서 new MemoryMemberRepository(): 구현체 생성한다!
        //new MemoryMemberRepository()는 새로운 MemoryMemberRepository 객체(인스턴스)를 생성하는 코드
        //참조값은 객체의 메모리 주소를 나타내는 값. 객체를 생성하면 해당 객체는 메모리의 특정 위치에 할당되고, 이 위치를 가리키는 값이 참조값.
        //toString() 오버라이드 안했으면 sysout했을 때 참조값이 나온다.
        //객체 생성시memberRepository()  참조값을 같이 넘긴다!

        //제어의 역전 IoC Inversion of Control
        //return new ExampleServiceImpl(memberRepository()) -> 이렇게 해도 memberServiceImpl은 모른다
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    //리턴타입은 인터페이스!
    public static MemberRepository memberRepository() {
        //DB를 바꿔야 할 때 여기만 수정하면 된다!
        return new MemoryMemberRepository();
    }


    //객체의 의존관계를 OrderServiceImpl에 주입해준다 new MemoryMemberRepository(),new FixDiscountPolicy()에 의해 생성된 새로운 객체인 MemoryMemberRepository, FixDiscountPolicy
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean //상위계층인 할인정책 -> 갈아끼우기만 하면 돼서 DIP 원칙은 지킨다
    public DiscountPolicy discountPolicy() {
        //할인 정책을 바꿔야 할 때 여기만 수정하면 된다!

          //히위계층인 할인 정책의 특정 예시2
//        return new FixDiscountPolicy();
        //히위계층인 할인 정책의 특정 예시2
        return new RateDiscountPolicy();
    }

}
