package by.itacademy.mikhalevich.icourse.servlet;

import by.itacademy.mikhalevich.icourse.GroupService;
import by.itacademy.mikhalevich.icourse.StudentService;
import by.itacademy.mikhalevich.icourse.TeacherService;
import by.itacademy.mikhalevich.icourse.service.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AbstractGroupController extends HttpServlet {

    private TeacherService teacherService;
    private StudentService studentService;
    private GroupService groupService;

    @Override
    public final void init() throws ServletException {
        teacherService = ServiceManager.getInstance(getServletContext()).getTeacherService();
        studentService = ServiceManager.getInstance(getServletContext()).getStudentService();
        groupService = ServiceManager.getInstance(getServletContext()).getGroupService();
    }

    public final TeacherService getTeacherService() {
        return teacherService;
    }
    public final StudentService getStudentService() {
        return studentService;
    }

    public final GroupService getGroupService() {
        return groupService;
    }

}