package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

MemberService memberService;


@BeforeEach //각 테스트 실행전에 실행됨
        public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
}


    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        //-> 검증 API
        //회원가입 계정과 find 의 결과가 똑같냐?
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
