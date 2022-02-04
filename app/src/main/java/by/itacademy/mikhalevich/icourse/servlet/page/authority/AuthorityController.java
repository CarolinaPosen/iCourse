package by.itacademy.mikhalevich.icourse.servlet.page.authority;

import by.itacademy.mikhalevich.icourse.AbstractAuthorityController;
import by.itacademy.mikhalevich.icourse.jpa.AuthorityRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.model.auth.Authority;
import by.itacademy.mikhalevich.icourse.model.auth.Role;
import by.itacademy.mikhalevich.icourse.servlet.AbstractRoleController;
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

@WebServlet("/authorities")
public class AuthorityController extends AbstractAuthorityController {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Map<Integer, Authority> roles = getAuthorityService().read();

            List<Authority> list = new ArrayList<Authority>(roles.values());

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