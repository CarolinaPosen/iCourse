package by.itacademy.mikhalevich.icourse.servlet;

import by.itacademy.mikhalevich.icourse.RoleService;
import by.itacademy.mikhalevich.icourse.ThemeService;
import by.itacademy.mikhalevich.icourse.service.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AbstractRoleController extends HttpServlet {

    private RoleService roleService;

    @Override
    public final void init() throws ServletException {
        roleService = ServiceManager.getInstance(getServletContext()).getRoleService();
    }

    public final RoleService getRoleService() {
        return roleService;
    }

}