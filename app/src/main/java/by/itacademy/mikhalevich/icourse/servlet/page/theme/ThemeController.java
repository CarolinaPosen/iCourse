package by.itacademy.mikhalevich.icourse.servlet.page.theme;

import by.itacademy.mikhalevich.icourse.dto.Trainers;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Theme;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractStudentController;
import by.itacademy.mikhalevich.icourse.servlet.AbstractThemeController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet("/themes")
public class ThemeController extends AbstractThemeController {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Map<Integer, Theme> themes = getThemeService().readTheme();

            List<Theme> list = new ArrayList<Theme>(themes.values());

            List<String> list1 = new ArrayList<String>(List.of("String", "MAP", "SET"));

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(list);
            PrintWriter writer = resp.getWriter();
            writer.print(json);
            writer.flush();

        }

    protected void writeEntityToBody(Object obj, HttpServletResponse resp) throws IOException {
        obj = (obj instanceof Optional) ? ((Optional<?>)obj).orElse(null): obj;
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(obj);
        PrintWriter writer = resp.getWriter();
        writer.print(json);
        writer.flush();
    }

    protected <T> T toEntity(Class<T> clazz, HttpServletRequest req) throws IOException {
        String body = req.getReader().lines().collect(Collectors.joining());
        ObjectMapper mapper = new ObjectMapper();
        T entity = mapper.readValue(body, clazz);
        return entity;
    }

}