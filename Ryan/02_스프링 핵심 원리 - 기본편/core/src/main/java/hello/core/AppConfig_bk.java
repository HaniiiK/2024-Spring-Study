//package hello.core;
//
//import hello.core.discount.DiscountPolicy;
//import hello.core.discount.RateDiscountPolicy;
//import hello.core.member.MemberRepository;
//import hello.core.member.MemberService;
//import hello.core.member.MemberServiceImpl;
//import hello.core.member.MemoryMemberRepository;
//import hello.core.order.OrderService;
//import hello.core.order.OrderServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
////설정 정보
//@Configuration
//public class AppConfig_bk {
////리팩토링해서 역할과 구현 클래스를 한눈에 들어오게했다. 전체 구성이 어떻게 되어있는지 파악 용이해짐
//
//    //객체를 만드는 생성자
//    @Bean //-> 스프링 컨테이너에 등록된다
//    public MemberService memberService() {
//        return new MemberServiceImpl(memberRepository());
//    }
//
//    @Bean
//    //리턴타입은 인터페이스!
//    public static MemberRepository memberRepository() {
//        //DB를 바꿔야 할 때 여기만 수정하면 된다!
//        return new MemoryMemberRepository();
//    }
//
//
//    //객체의 의존관계를 OrderServiceImpl에 주입해준다 new MemoryMemberRepository(),new FixDiscountPolicy()에 의해 생성된 새로운 객체인 MemoryMemberRepository, FixDiscountPolicy
//    @Bean
//    public OrderService orderService() {
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
//    }
//
//    @Bean //상위계층인 할인정책 -> 갈아끼우기만 하면 돼서 DIP 원칙은 지킨다
//    public DiscountPolicy discountPolicy() {
//        //return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
//    }
//
//}
