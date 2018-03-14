import dao.CategoryDAO;
import dao.DAO;
import dao.impl.CategoryDAOImpl;
import dao.impl.DAOPostgre;
import entities.Category;
import entities.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = -4751096228274971485L;
    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session =reqest.getSession();
        DAO dao = new DAOPostgre();
        dao.setURL(DAOPostgre.DEFAULT_HOST, DAOPostgre.DEFAULT_DATABASE, DAOPostgre.DEFAULT_PORT);
        dao.connect(DAOPostgre.DEFAULT_LOGIN, DAOPostgre.DEFAULT_PASSWORD);
        CategoryDAO categoryDAO = new CategoryDAOImpl(dao);
        Category category = categoryDAO.getCategories().get(0);
        response.getWriter().println("Hello World! Category = " + category.getName());
    }
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }
    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }
}
