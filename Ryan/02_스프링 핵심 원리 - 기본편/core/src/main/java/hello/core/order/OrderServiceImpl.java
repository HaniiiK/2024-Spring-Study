package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class OrderServiceImpl implements OrderService {
    //인스턴스 변수 = memberRepository, discountPolicy (멤버변수) =/= 클래스(설계도)와 인스턴스. 인스턴스는 클래스의 실제 객체
    //DIP(Dependency Inversion Principle)를 지키고 있다. 인터페이스(추상화)에만 의존한다. 구체적인 클래스에 대해서는 전혀 모른다.
    //맞습니다. 인터페이스 타입의 멤버 변수를 사용함으로써 해당 인터페이스에 정의된 메서드들을 활용할 수 있다.
    // 인터페이스를 멤버 변수로 사용하면 해당 인터페이스에 선언된 메서드들을 해당 클래스에서 구현한 것처럼 사용할 수 있다.
    //정적인 의존관계
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    //1.  final있으면 생성자를 통해서 값이 할당 되어야 한다.


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        //2. -> 이렇게
        //OrderServiceImpl 클래스의 생성자는
        // memberRepository와 discountPolicy를 매개 변수로 받아서 인스턴스 변수인 memberRepository와 discountPolicy에 할당하고 있다.
        this.memberRepository = memberRepository;   //this가 위의 멤버변수이다. 멤버변수에 '할당'된다.
        this.discountPolicy = discountPolicy;
    }


//    private DiscountPolicy discountPolicy;
    //DIP 만족 but nullPointException -> 클라이언트인 OrderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입해주어야 한다.

//private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

//생성자 만듦. 생성자를 통해서 MemberRespository의 구현체에 뭐가 들어갈지를 정한다.


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
