package controller;

import dao.CategoryDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.CategoryDAOImpl;
import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
import entities.Category;
import entities.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product.html")
public class ProductController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
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
        String forward = "/index.jsp";

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = productDAO.find(id);
            if (product == null) {
                forward = "/404.jsp";
            } else {
                request.setAttribute("categories", categoryDAO.findAll());
                request.setAttribute("product", product);
                request.setAttribute("currentCategory", product.getCategory());
                forward = "product.jsp";
            }
        } catch (NumberFormatException e) {
            forward = "/404.jsp";
        }

        request.getRequestDispatcher(forward).forward(request, response);
    }
}
