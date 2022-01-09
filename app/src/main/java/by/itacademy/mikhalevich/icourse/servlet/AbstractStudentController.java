package by.itacademy.mikhalevich.icourse.servlet;

import by.itacademy.mikhalevich.icourse.MarkService;
import by.itacademy.mikhalevich.icourse.StudentService;
import by.itacademy.mikhalevich.icourse.ThemeService;
import by.itacademy.mikhalevich.icourse.service.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AbstractStudentController extends HttpServlet {

    private StudentService studentService;
    private MarkService markService;
    private ThemeService themeService;

    @Override
    public final void init() throws ServletException {
        studentService = ServiceManager.getInstance(getServletContext()).getStudentService();
        markService = ServiceManager.getInstance(getServletContext()).getMarkService();
        themeService = ServiceManager.getInstance(getServletContext()).getThemeService();
    }

    public final StudentService getStudentService() {
        return studentService;
    }
    public final MarkService getMarkService() {
        return markService;
    }
    public final ThemeService getThemeService() {
        return themeService;
    }

}