package by.itacademy.mikhalevich.icourse.servlet;

import by.itacademy.mikhalevich.icourse.ThemeService;
import by.itacademy.mikhalevich.icourse.service.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AbstractThemeController extends HttpServlet {

    private ThemeService themeService;

    @Override
    public final void init() throws ServletException {
        themeService = ServiceManager.getInstance(getServletContext()).getThemeService();
    }

    public final ThemeService getThemeService() {
        return themeService;
    }

}