package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.model.CurrentAccount;
import by.itacademy.mikhalevich.icourse.servlet.AbstractController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;
import by.itacademy.mikhalevich.icourse.util.SessionUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sign-in")
public class SignInController extends AbstractController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (SessionUtils.isCurrentAccountCreated(req)) {
			RoutingUtils.redirect("/web-app/teachers", req, resp);
		} else {
			req.getRequestDispatcher("/WEB-INF/JSP/page/sign-in.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (SessionUtils.isCurrentAccountCreated(req)) {
			RoutingUtils.redirect("/web-app/teachers", req, resp);
		} else {

			CurrentAccount currentAccount =
					getAccountService().authentificate(req.getParameter("login"), req.getParameter("password"));

			if (currentAccount!=null){
				SessionUtils.setCurrentAccount(req, currentAccount);
				RoutingUtils.redirect("/web-app/teachers", req, resp);
			}else{
				req.getRequestDispatcher("/WEB-INF/JSP/page/sign-in.jsp").forward(req, resp);
			}
		}
	}
}
