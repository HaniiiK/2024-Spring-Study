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


//설정 정보
@Configuration
public class AppConfig {
    @Bean
    //직접 메서드를 만 섹션3의 3강. 관심사의 분리 6분
    public MemberService memberService() {
//1번
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
//1번
        System.out.println("call AppConfig.orderService");
//        return new OrderServiceImpl(
//                memberRepository(),
//                discountPolicy());
        return null;
    }

    @Bean
    public MemberRepository memberRepository() {
//2번? 3번?
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

