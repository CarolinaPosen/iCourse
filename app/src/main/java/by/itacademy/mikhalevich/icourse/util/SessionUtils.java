package by.itacademy.mikhalevich.icourse.util;

import javax.servlet.http.HttpServletRequest;
import by.itacademy.mikhalevich.icourse.Constants;
import by.itacademy.mikhalevich.icourse.model.CurrentAccount;


public class SessionUtils {

	private SessionUtils() {
	}

	public static CurrentAccount getCurrentAccount(HttpServletRequest req) {
		return (CurrentAccount) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);
	}

	public static void setCurrentAccount(HttpServletRequest req, CurrentAccount currentAccount) {
		req.getSession().setAttribute(Constants.CURRENT_ACCOUNT, currentAccount);
	}

	public static boolean isCurrentAccountCreated(HttpServletRequest req) {
		return getCurrentAccount(req) != null;
	}
}
