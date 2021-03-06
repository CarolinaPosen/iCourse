package by.itacademy.mikhalevich.icours.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class RoutingUtils {

	public static void forwardToPage(String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("currentPage", "page/" + jspPage);
		req.getRequestDispatcher("/WEB-INF/JSP/page-template.jsp").forward(req, resp);
	}

	public static void redirect(String url, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendRedirect(url);
	}
}
