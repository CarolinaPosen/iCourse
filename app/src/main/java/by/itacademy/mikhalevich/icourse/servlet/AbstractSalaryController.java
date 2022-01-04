package by.itacademy.mikhalevich.icourse.servlet;

import by.itacademy.mikhalevich.icourse.SalaryService;
import by.itacademy.mikhalevich.icourse.TeacherService;
import by.itacademy.mikhalevich.icourse.impl.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AbstractSalaryController extends HttpServlet {

    private TeacherService teacherService;
    private SalaryService salaryService;

    @Override
    public final void init() throws ServletException {
        teacherService = ServiceManager.getInstance(getServletContext()).getTeacherService();
        salaryService = ServiceManager.getInstance(getServletContext()).getSalaryService();
    }
    public final TeacherService getTeacherService() {
        return teacherService;
    }
    public final SalaryService getSalaryService() {
        return salaryService;
    }

}