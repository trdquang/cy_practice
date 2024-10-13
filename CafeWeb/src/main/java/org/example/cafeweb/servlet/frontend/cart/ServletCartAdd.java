package org.example.cafeweb.servlet.frontend.cart;

import org.example.cafeweb.dto.request.CartRequest;
import org.example.cafeweb.dto.response.ProductResponse;
import org.example.cafeweb.service.ICartService;
import org.example.cafeweb.service.IProductSerice;
import org.example.cafeweb.service.impl.CartService;
import org.example.cafeweb.service.impl.ProductService;
import org.example.cafeweb.util.PathUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addCart", value = "/addCart")
public class ServletCartAdd extends HttpServlet {
    private IProductSerice productSerice = new ProductService();
    private ICartService cartService = new CartService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PathUtil.pathFE_jsp + "cart-add.jsp");
        String id = req.getParameter("idProduct");
        ProductResponse productResponse = productSerice.findById(id);

        req.setAttribute("product", productResponse);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProduct = req.getParameter("idProduct");
        int quantity =  Integer.parseInt(req.getParameter("quantity"));
        double price =  Double.parseDouble(req.getParameter("price"));

        CartRequest cartRequest = new CartRequest(496, idProduct, quantity, price);
        System.out.println("cart request: " + cartRequest.getProductCode() +", " +
                cartRequest.getQuantity() + ", " + cartRequest.getPriceEach());
        cartService.add(cartRequest);

        resp.sendRedirect("cart");
    }
}
