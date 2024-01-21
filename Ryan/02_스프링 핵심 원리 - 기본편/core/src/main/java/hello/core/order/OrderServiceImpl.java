package hello.core.order;

import hello.core.discount.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

     private  MemberRepository memberRepository;
     private  DiscountPolicy discountPolicy;
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }



    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }

    //테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
    //빈 존재 확인memberRepository
}
