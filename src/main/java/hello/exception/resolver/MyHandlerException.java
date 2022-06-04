package hello.exception.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class MyHandlerException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try {

            if (ex instanceof IllegalAccessException) {
                log.info("IllegalAccessException");
                // 익셉션을 sendError 로 바꿔치기 한것이다.
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());

                //return 을 하게 되면 예외를 여기서 먹는거다 정상리턴으로 되고 서블릿 은 우리가 넣어준 400 에러로 된다.
                return new ModelAndView();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        // null 인경우 예외가 계속 전달 된다.
        return null;
    }
}
