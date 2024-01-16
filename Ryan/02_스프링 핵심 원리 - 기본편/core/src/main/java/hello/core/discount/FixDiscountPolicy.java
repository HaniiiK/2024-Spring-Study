package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;


public class FixDiscountPolicy implements DiscountPolicy {

    //고정금액 할인 1000원 할인
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        //enom 타입이라서 == 사용
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }else {
            return 0; //할인 금액 없다는 뜻
        }
    }
}
