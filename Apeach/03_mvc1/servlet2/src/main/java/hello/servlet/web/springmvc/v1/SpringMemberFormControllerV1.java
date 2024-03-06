package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//(1) @Component 가 붙어있어서 스캔 인식 대상이 되어 빈으로 자동 등록
//(2) @RequestMapping 과 함께 매핑된다.
// @Component + @RequestMapping 을 클래스레벨에서 함께 적어두어도 된다.
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new_form")
    public ModelAndView process() {
        return new ModelAndView("new_form");
    }
}
