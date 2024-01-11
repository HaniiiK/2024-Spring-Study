package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp_sub {

    public static void main(String[] args) {
        // "appConfig" 객체에서 "memberService"를 얻어와서 이를 "MemberService" 타입의 변수인 "memberService"에 할당하는 코드.
        // 이 코드를 통해 "appConfig"는 "MemberService"의 구현체를 생성하고 반환하는 것
//        AppConfig appConfig = new AppConfig(); // new AppConfig();  : 생성자를 통해서 객체(Impl)를 만든다.
//            MemberService memberService = appConfig.memberService();

            //memberService인터페이스 안에 memberServiceImpl 있다! MemoryMemberRepository의 구현체를 주입
        //// memberService는 MemberServiceImpl의 객체를 참조하지만, MemberService 타입으로 선언되었다.
        //// MemberService 인터페이스에 정의된 메서드만 호출 가능!!!!
        // MemberServiceImpl에 있는 메서드는 MemberService 인터페이스에 있는 메서드를 구현한 것에 불과하다!!
//스프링 컨테이너
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //이렇게 하면 컨테이너에 객체 생성한 것을 집어넣어서 관리해준다.
        //메서드 이름으로 등록된다. 키값"memberService" 기준으로 찾는다. 타입은 MemberService


        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP); //long type이라서 L 붙여줘야함

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());





    }
}
