package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp_bk {
    public static void main(String[] args) {
        // 언제든지 구현체를 갈아끼우기 쉽게하기 위해 왼쪽에 추상클래스를 두고, 이를 구현한 것을 생성자로 사용한다.
        //변수타입 변수명 = new 변수(타입)을 (구현한)생성자
//        AppConfig appConfig = new AppConfig();
//      MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        // memberService,orderService의 결과는MemberService, OrderService 인스턴스 타입의 impl이다. 인스턴스의 메서드를 구현한 구현체이다.
     ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //이렇게 하면 컨테이너에 객체 생성한 것을 집어넣어서 관리해준다.
        //"메서드 이름" 으로 등록된다. 키값"memberService" 기준으로 찾는다. 타입은 MemberSe rvice

        //getBean 빈 가져와! "memberService" 이름!  return인  memberService 객체를 가져온다
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        // ->orderService 생성하면  new OrderServiceImpl 나온다
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
