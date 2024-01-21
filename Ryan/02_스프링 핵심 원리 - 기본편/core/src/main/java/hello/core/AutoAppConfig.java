package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
 @ComponentScan(
//         basePackages = "hello.core.member",
         //제외하는 이유: 앞의 예제에서 @Configuration(안에 @Component있음)이 붙은 AppConfig를 만들어 놨기 때문에. Scan에서 제외하려고. 이미 빈 생성되어있으니까 실습에 방해됨
         excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
 Configuration.class)
 )
 public class AutoAppConfig {
//     @Bean(name = "memoryMemberRepository")
//     public MemberRepository memberRepository() {
//         return new MemoryMemberRepository();
//     }
}
