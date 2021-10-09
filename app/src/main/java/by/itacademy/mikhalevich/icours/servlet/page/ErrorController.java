package by.itacademy.mikhalevich.icours.servlet.page;

import by.itacademy.mikhalevich.icours.servlet.AbstractController;
import by.itacademy.mikhalevich.icours.util.RoutingUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/error")
public class ErrorController extends AbstractController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoutingUtils.forwardToPage("error.jsp", req, resp);
	}
}
