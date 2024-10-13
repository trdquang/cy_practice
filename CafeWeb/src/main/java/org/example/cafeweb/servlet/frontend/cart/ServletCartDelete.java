package org.example.cafeweb.servlet.frontend.cart;

import org.example.cafeweb.dto.request.CartRequest;
import org.example.cafeweb.service.ICartService;
import org.example.cafeweb.service.IProductSerice;
import org.example.cafeweb.service.impl.CartService;
import org.example.cafeweb.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteCart", value = "/deleteCart")
public class ServletCartDelete extends HttpServlet {
    private IProductSerice productSerice = new ProductService();
    private ICartService cartService = new CartService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idCart = Integer.parseInt(req.getParameter("idCart"));
        cartService.deleteById(idCart);

        resp.sendRedirect("cart");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
