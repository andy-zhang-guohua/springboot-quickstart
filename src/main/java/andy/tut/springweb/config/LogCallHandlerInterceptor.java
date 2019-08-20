package andy.tut.springweb.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author ZhangGuohua
 * @date 2019-08-12
 */
@Slf4j
public class LogCallHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestURI = request.getRequestURI();
        Map<String, String[]> parameters = request.getParameterMap();
        log.info("preHandle :{} ==> handler : {}, parameters : {}", requestURI, handler, parameters);
        return true;
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) {
        String requestURI = request.getRequestURI();
        log.info("postHandle :{} ==> {} : {}", requestURI, handler, modelAndView);
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) {
        String requestURI = request.getRequestURI();
        log.info("afterCompletion :{} ==> {} : ex={}", requestURI, handler, ex);
    }
}
