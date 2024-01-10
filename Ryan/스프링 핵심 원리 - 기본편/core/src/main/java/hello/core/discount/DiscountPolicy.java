package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    //리턴 할인 대상 금액 얼마가 할인됐는지!
    int discount(Member member, int price);
}
