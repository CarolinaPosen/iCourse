package by.itacademy.mikhalevich.icourse;

import by.itacademy.mikhalevich.icourse.service.AuthorityService;
import by.itacademy.mikhalevich.icourse.service.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AbstractAuthorityController extends HttpServlet {

    private AuthorityService authorityService;

    @Override
    public final void init() throws ServletException {
        authorityService = ServiceManager.getInstance(getServletContext()).getAuthorityService();
    }

    public final AuthorityService getAuthorityService() {
        return authorityService;
    }

}