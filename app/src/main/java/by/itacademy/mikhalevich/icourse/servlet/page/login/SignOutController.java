package by.itacademy.mikhalevich.icourse.servlet.page.login;

import by.itacademy.mikhalevich.icourse.servlet.AccountController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/sign-out")
public class SignOutController extends AccountController {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		RoutingUtils.redirect("/web-app/sign-in", req, resp);
	}
}
