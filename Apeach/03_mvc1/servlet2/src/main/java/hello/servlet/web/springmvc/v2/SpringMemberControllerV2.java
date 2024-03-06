package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("springmvc/v2/members")
public class SpringMemberControllerV2 {
    //v1 Controller 를 모두 한 곳에 넣어둠
    //RequestMapping 은 메소드 단위로 가능하기 때문에 할 수 있는 것

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new_form")
    public ModelAndView newForm() {
        return new ModelAndView("new_form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        //mv.getModel().put("member", member);
        mv.addObject("member", member); //모델에 값을 넣어줌
        return mv;
    }

    @RequestMapping
    public ModelAndView members() {

        List<Member> members = memberRepository.findAll();

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }
}
