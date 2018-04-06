package controller;

import dao.CategoryDAO;
import dao.impl.CategoryDAOImpl;
import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class IndexController
 */
@WebServlet({"", "/index.html"})
public class IndexController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        categoryDAO = new CategoryDAOImpl();
        productDAO = new ProductDAOImpl();
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("categories", categoryDAO.findAll());
        request.setAttribute("products", productDAO.findAll(9));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
