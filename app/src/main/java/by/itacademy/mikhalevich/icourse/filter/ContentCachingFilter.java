package by.itacademy.mikhalevich.icourse.filter;

import by.itacademy.mikhalevich.icourse.api.interceptors.InterceptorCachingRequestWrapper;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/api/*")
public class ContentCachingFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        InterceptorCachingRequestWrapper requestWrapper = new InterceptorCachingRequestWrapper((HttpServletRequest) req);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) resp);
        chain.doFilter(requestWrapper, responseWrapper);
        responseWrapper.copyBodyToResponse();
    }
}
