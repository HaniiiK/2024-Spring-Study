package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//스프링컨테이너에 빈 붙은거 객체 생성한 거 다 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //메서드 이름으로 등록됨-> 이름과 타입으로 찾겠다.  "memberService": 이름(키 값)   MemberService.class: 타입(밸류는 객체 인스턴스  )
        //@ Bean했는걸 get해와서 생성자로 사용해서 객체 생성한다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP); //long type이라서 L 붙여줘야함

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());





    }
}
