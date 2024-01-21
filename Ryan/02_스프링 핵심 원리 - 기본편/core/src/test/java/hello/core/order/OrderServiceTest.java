package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

//    public OrderServiceTest(MemberService memberService, OrderService orderService) {
//        this.memberService = memberService;
//        this.orderService = orderService;
//    }

//    @Test
//    void createOrder(){
//        Long memberId = 1L;
//        Member member = new Member(memberId, "memberA", Grade.VIP);
//        memberService.join(member);
//
//        Order order = orderService.createOrder(memberId, "itemA", 10000);
//        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
//    }
//    @Test
//    void fieldInjectionTest(){
//        OrderServiceImpl orderService =new OrderServiceImpl();
////        orderService.setDiscountPolicy(new FixDiscountPolicy() );
////        orderService.setMemberRepository(new MemoryMemberRepository());
//                orderService.createOrder(1L,"itemA",10000);
//
//    }
}
