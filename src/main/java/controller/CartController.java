package controller;

import dao.ProductDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.impl.ProductDAOImpl;
import entities.Cart;
import entities.Item;
import entities.Product;
import java.util.List;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart.html")
public class CartController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private ProductDAO productDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
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
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (action.equals("view")) { // View cart
            if (cart == null || cart.getCount() == 0) {
                session.setAttribute("error", "Your cart is empty now");
                response.sendRedirect("index.html");
            } else {
                request.getRequestDispatcher("/cart.jsp").forward(request, response);
            }
        } else { // Add or remove an item
            if (cart == null) {
                cart = new Cart();
            }

            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Product product = productDAO.find(id);
                if (product == null) {
                    request.getRequestDispatcher("/404.jsp").forward(request, response);
                } else {
                    if (action.equals("add")) { // Add
                        cart.add(new Item(product, 1));
                    } else { // Remove
                        cart.remove(product.getId());
                    }
                    session.setAttribute("cart", cart);
                    response.sendRedirect("cart.html?action=view");
                }
            } catch (NumberFormatException e) {
                request.getRequestDispatcher("/404.jsp").forward(request, response);
            }
        }
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
        HttpSession session = request.getSession(false);
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart.getCount() == 0) {
            session.setAttribute("error", "Your cart is empty!");
            response.sendRedirect("index.html");
        } else {
            List<Item> items = cart.getItems();
            for (Item e : items) {
                try {
                    int newQuantity = Integer.parseInt(
                            request.getParameter(String.valueOf(e.getProduct().getId())));
                    if (newQuantity == 0) {
                        items.remove(e);
                    } else {
                        e.setQuantity(newQuantity);
                    }
                } catch (NumberFormatException ex) {
                    session.setAttribute("error", "Please enter numeric quantity!");
                    break;
                }
            }
            session.setAttribute("cart", cart);
            response.sendRedirect("cart.html?action=view");
        }
    }
}
