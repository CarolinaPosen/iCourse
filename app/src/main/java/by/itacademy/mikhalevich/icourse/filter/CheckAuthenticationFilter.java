//package by.itacademy.mikhalevich.icourse.filter;
//
//import java.io.IOException;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import by.itacademy.mikhalevich.icourse.util.RoutingUtils;
//import by.itacademy.mikhalevich.icourse.util.SessionUtils;
//
//@WebFilter(filterName = "CheckAuthenticationFilter")
//public class CheckAuthenticationFilter implements Filter {
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//	}
//
//	@Override
//	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//		HttpServletRequest req = (HttpServletRequest) servletRequest;
//		HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//		if (SessionUtils.isCurrentAccountCreated(req)) {
//			filterChain.doFilter(servletRequest, servletResponse);
//		} else {
//			RoutingUtils.redirect("/web-app/sign-in", req, resp);
//		}
//	}
//
//	@Override
//	public void destroy() {
//
//	}
//}

