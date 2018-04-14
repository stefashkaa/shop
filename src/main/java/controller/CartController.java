package controller;

import dao.OrderDAO;
import dao.ProductDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.impl.OrderDAOImpl;
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
    private OrderDAO orderDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        productDAO = new ProductDAOImpl();
        orderDAO = new OrderDAOImpl();
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
        doPost(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Cart cart = (Cart) session.getAttribute("cart");

        String action = request.getParameter("action");
        if(action == null || action.equals("")) {
            if (cart == null) {
                request.getRequestDispatcher("/404.jsp").forward(request, response);
            } else if (cart.getCount() == 0) {
                session.setAttribute("error", "Your cart is empty!");
                response.sendRedirect("index.html");
            } else {
                update(session, cart, request);
                session.setAttribute("cart", cart);
                response.sendRedirect("cart.html?action=view");
            }
            return;
        }
        switch (action) {
            case "view":
                view(request, response);
                break;
            case "index":
                update(session, cart, request);
                response.sendRedirect("index.html");
                break;
            case "checkout":
                update(session, cart, request);
                response.sendRedirect("checkout.html");
                break;
            case "add":
                add(request, response);
                break;
            case "remove":
                remove(request, response);
                break;
            default:
                request.getRequestDispatcher("/404.jsp").forward(request, response);
                break;
        }
    }

    private void view(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getCount() == 0) {
            session.setAttribute("error", "Your cart is empty now");
            response.sendRedirect("index.html");
        } else {
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        }
    }

    private void update(HttpSession session, Cart cart, HttpServletRequest request) {
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
        orderDAO.update(cart);
    }

    private void add(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = productDAO.find(id);
            if (product == null) {
                request.getRequestDispatcher("/404.jsp").forward(request, response);
            } else {
                boolean isExists = false;
                for (Item i : cart.getItems()) {
                    if(i.getProduct().getId() == product.getId()) {
                        isExists = true;
                        session.setAttribute("error", "This product is already added to cart!");
                    }
                }
                if(!isExists) {
                    cart.add(new Item(product, 1));
                }
                session.setAttribute("cart", cart);
                response.sendRedirect("cart.html?action=view");
            }
        } catch (NumberFormatException e) {
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = productDAO.find(id);
            if (product == null) {
                request.getRequestDispatcher("/404.jsp").forward(request, response);
            } else {
                cart.remove(product.getId());
                session.setAttribute("cart", cart);
                response.sendRedirect("cart.html?action=view");
            }
        } catch (NumberFormatException e) {
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }
}