package by.itacademy.mikhalevich.icourse.filter;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicLoginFilter implements Filter {

    /**
     * List of roles the user must have to authenticate
     */
    private final List<String> roleNames = new ArrayList<String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String roleNamesParam = filterConfig.getInitParameter("role-names-comma-sep");
        if (roleNamesParam != null) {
            for (String roleName: roleNamesParam.split(",")) {
                roleNames.add(roleName);
            }
        }
    }

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BASIC_PREFIX = "Basic ";

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
/*        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        // get username and password from the Authorization header
        String authHeader = request.getHeader(AUTHORIZATION_HEADER);
        if (authHeader == null || !authHeader.startsWith(BASIC_PREFIX)) {
            throwBasicAuthRequired();
        }

        String userPassBase64 = authHeader.substring(BASIC_PREFIX.length());
        String userPassDecoded = new String(Base64.decodeBase64(userPassBase64), B2CConverter.ISO_8859_1);// decode from base64 any other way, if this won't work for you. Finally userPassDecoded must contain readable "username:password"
        if (!userPassDecoded.contains(":")) {
            throwBasicAuthRequired();
        }

        String authUser = userPassDecoded.substring(0, userPassDecoded.indexOf(':'));
        String authPass = userPassDecoded.substring(userPassDecoded.indexOf(':') + 1);

        // do login manually
        request.login(authUser, authPass);

        // check roles for the user
        final Principal userPrincipal = request.getUserPrincipal();

        // Your Principal will be another class, not MemoryUser. Run in debug mode to see what class you actually have. The role checking will depend on that class.
        MemoryUser user = (MemoryUser)userPrincipal;

        boolean hasRoles = true;
        for (String role: roleNames) {
            if (role == null) {
                continue;
            }
            boolean hasRole = false;
            Iterator<Role> roles = user.getRoles();
            while (roles.hasNext()) {
                if (role.equals(roles.next().getName())) {
                    hasRole = true;
                    break;
                }
            }
            if (!hasRole) {
                hasRoles = false;
                break;
            }
        }

        if (hasRoles) {
            // login successful
            chain.doFilter(request, response);
            request.logout();// optional
        } else {
            // login failed
            throwLoginFailed();
        }*/
    }

    @Override
    public void destroy() {
    }

    public static void throwBasicAuthRequired() throws ServletException {
        throw new ServletException("The /app/services resources require BASIC authentication");
    }

    public static void throwLoginFailed() throws ServletException {
        throw new ServletException("Login failed");
    }
}