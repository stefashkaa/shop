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
import java.util.List;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/category.html")
public class CategoryController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
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

            boolean flag = false;
            List<Category> categories = categoryDAO.findAll();
            Category current = null;
            for (Category category : categories) {
                if (category.getId() == id) {
                    current = category;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                request.setAttribute("categories", categories);
                request.setAttribute("category", current);
                request.setAttribute("products", productDAO.findByCategory(id));
                forward = "/category.jsp";
            } else {
                forward = "/404.jsp";
            }
        } catch (NumberFormatException e) {
            forward = "/404.jsp";
        }

        request.getRequestDispatcher(forward).forward(request, response);
    }
}
