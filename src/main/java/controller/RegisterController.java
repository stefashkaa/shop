package controller;

import dao.UserDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.impl.UserDAOImpl;
import entities.User;
import java.util.List;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register.html")
public class RegisterController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDAO userDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        userDAO = new UserDAOImpl();
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        List<String> errors = new ArrayList<>();
        if (name.equals("") || email.equals("") || password.equals("") || confirmPassword.equals("")) {
            errors.add("Please enter all required fields!");
        }
        if (!password.equals(confirmPassword)) {
            errors.add("Password not matching!");
        }
        if (userDAO.exists(email)) {
            errors.add("Email already exists!");
        }

        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            userDAO.save(new User(name, email, password));
            HttpSession session = request.getSession();
            session.setAttribute("success", "Register successfully");
            response.sendRedirect("index.html");
        }
    }
}
