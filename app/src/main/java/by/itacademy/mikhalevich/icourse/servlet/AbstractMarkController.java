package by.itacademy.mikhalevich.icourse.servlet;

import by.itacademy.mikhalevich.icourse.MarkService;
import by.itacademy.mikhalevich.icourse.StudentService;
import by.itacademy.mikhalevich.icourse.impl.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AbstractMarkController extends HttpServlet {

    private StudentService studentService;
    private MarkService markService;

    @Override
    public final void init() throws ServletException {
        studentService = ServiceManager.getInstance(getServletContext()).getStudentService();
        markService = ServiceManager.getInstance(getServletContext()).getMarkService();
    }

    public final StudentService getStudentService() {
        return studentService;
    }
    public final MarkService getMarkService() {
        return markService;
    }

}