package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    /*
    * 참고사이트 : https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-annarguments
    *
    * return 관련 : https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods/return-types.html
    * ex) return ResponseEntity<B>
    */
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request, /* request 정보 */
                          HttpServletResponse response, /* reponse 정보 */
                          HttpMethod httpMethod, /* Method(get or post) 정보 */
                          Locale locale, /* Locale(ex->ko_KR) 정보 */
                          @RequestHeader MultiValueMap<String, String> headerMap, /* header 정보 */
                          @RequestHeader("host") String host, /* header의 host 정보 */
                          @CookieValue(value = "myCookie", required = false) String cookie /* cookie 정보 */
    ) {
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok";
    }
}
