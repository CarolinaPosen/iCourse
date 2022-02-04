package by.itacademy.mikhalevich.icourse.servlet.page.role;

import by.itacademy.mikhalevich.icourse.model.Theme;
import by.itacademy.mikhalevich.icourse.model.auth.Role;
import by.itacademy.mikhalevich.icourse.servlet.AbstractRoleController;
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

@WebServlet("/roles")
public class RoleController extends AbstractRoleController {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Map<Integer, Role> roles = getRoleService().read();

            List<Role> list = new ArrayList<Role>(roles.values());

//            List<String> list1 = new ArrayList<String>(List.of("String", "MAP", "SET"));

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(list);
            PrintWriter writer = resp.getWriter();
            writer.print(json);
            writer.flush();

        }
}