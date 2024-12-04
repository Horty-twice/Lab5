package socialnetwork.controller;

import socialnetwork.model.User;
import socialnetwork.service.AuthService;
import socialnetwork.service.VisitCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class AuthController extends HttpServlet {
    private AuthService authService = new AuthService();
    private VisitCounter visitCounter = new VisitCounter();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        visitCounter.increment();
        request.setAttribute("visitCount", visitCounter.getCount());
        request.getRequestDispatcher("user.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (authService.authenticate(username, password)) {
            HttpSession session = request.getSession();
            User user = authService.getUser(username);
            session.setAttribute("user", user);
            response.sendRedirect("user.html"); // Перенаправление в кабинет пользователя
        } else {
            response.sendRedirect("login.html?error=true"); // Ошибка аутентификации
        }
    }
}