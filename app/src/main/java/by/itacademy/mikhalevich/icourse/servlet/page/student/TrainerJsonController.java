package by.itacademy.mikhalevich.icourse.servlet.page.student;

import by.itacademy.mikhalevich.icourse.model.Theme;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractTeacherController;
import by.itacademy.mikhalevich.icourse.servlet.AbstractThemeController;
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

@WebServlet("/trainers")
public class TrainerJsonController extends AbstractTeacherController {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Map<Integer, Trainer> trainers = getTeacherService().read();

            List<Trainer> list = new ArrayList<Trainer>(trainers.values());

//            List<String> list1 = new ArrayList<String>(List.of("String", "MAP", "SET"));

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