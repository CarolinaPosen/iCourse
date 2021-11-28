package by.itacademy.mikhalevich.icourse.servlet;

import by.itacademy.mikhalevich.icourse.logic.*;
import by.itacademy.mikhalevich.icourse.logic.impl.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AccountController extends HttpServlet {

    private AccountService accountService;

    @Override
    public final void init() throws ServletException {
        accountService = ServiceManager.getInstance(getServletContext()).getAccountService();
    }

    public final AccountService getAccountService() {
        return accountService;
    }

}
