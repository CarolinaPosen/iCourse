package by.itacademy.mikhalevich.icourse.api.interceptors;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;

@Slf4j
@Component
public class LoggingInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        logUrl(req);
        logHeaders(req);
        logBody(req);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView modelAndView) throws Exception {
        ContentCachingResponseWrapper responseWrapper = (ContentCachingResponseWrapper) resp;
        String body = new String(responseWrapper.getContentAsByteArray(), req.getCharacterEncoding());
        log.info("Response Body: \n {}", body);
    }

    @SneakyThrows
    private void logBody(HttpServletRequest req) {
        InterceptorCachingRequestWrapper requestWrapper = (InterceptorCachingRequestWrapper) req;
        String body = new String(requestWrapper.getContentAsByteArray(), req.getCharacterEncoding());
        log.info("Request Body: \n {}", body);
    }

    private void logHeaders(HttpServletRequest req) {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            log.info("[{}]: {}", name, req.getHeader(name));
        }
    }

    private void logUrl(HttpServletRequest req) {
        log.info("Request {}, {}", req.getMethod(), ServletUriComponentsBuilder.fromRequest(req).toUriString());
    }
}
