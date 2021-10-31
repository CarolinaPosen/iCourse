package by.itacademy.mikhalevich.icourse.servlet;

import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractController;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.stream.Collectors;

public class JsonController extends AbstractController {

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
