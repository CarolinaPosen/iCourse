package by.itacademy.mikhalevich.icourse;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value = "/average-salary")
public class AverageSalary extends HttpServlet {

    /*private List<Teacher> teachers;

    @Override
    public void init() throws ServletException {
        super.init();
        teachers = initModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style='color: blue;'>Средняя зарплата следующих преподавателей: "
                + averageSalary(teachers)+ "</span></p>");
        teachers.forEach(teacher -> writer.write(teacher.getInfo() + "</p>"));
    }

    private BigDecimal averageSalary(List<Teacher> teachers) {
        List<Integer> salaries = teachers.stream()
                .map(Teacher::getSalary)
                .collect(Collectors.toList());
        return Accounting.average(salaries).setScale(2, RoundingMode.HALF_UP);
    }

    private List<Teacher> initModel() {
        return List.of(
                new Teacher("John", 30, 2000),
                new Teacher("John", 35, 1100),
                new Teacher("John", 30, 1200)
        );
    }*/
}
