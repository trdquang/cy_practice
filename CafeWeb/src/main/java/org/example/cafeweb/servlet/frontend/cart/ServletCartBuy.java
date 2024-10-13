package org.example.cafeweb.servlet.frontend.cart;

import org.example.cafeweb.dto.request.CartToBuy;
import org.example.cafeweb.dto.request.OrderDetailRequest;
import org.example.cafeweb.dto.request.OrderRequest;
import org.example.cafeweb.dto.response.CartRespone;
import org.example.cafeweb.dto.response.ProductResponse;
import org.example.cafeweb.service.ICartService;
import org.example.cafeweb.service.IOrderDetailService;
import org.example.cafeweb.service.IOrderService;
import org.example.cafeweb.service.IProductSerice;
import org.example.cafeweb.service.impl.CartService;
import org.example.cafeweb.service.impl.OrderDetailService;
import org.example.cafeweb.service.impl.OrderService;
import org.example.cafeweb.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "buyCart", value = "/buyCart")
public class ServletCartBuy extends HttpServlet {
    private ICartService cartService = new CartService();
    private IOrderDetailService orderDetailService = new OrderDetailService();
    private IOrderService orderService = new OrderService();
    private IProductSerice productSerice = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] selectedCartIds = req.getParameterValues("selectedCartIds");
        List<CartToBuy> cartToBuyList = new ArrayList<>();

        Map<String, Integer> cartProductList = new HashMap<>();
        for(String it: selectedCartIds){
           if(it != null && it != ""){
               int key = Integer.parseInt(it);
               CartRespone cartRespone = cartService.findById(key);
               cartProductList.put(cartRespone.getProductCode(),
                       cartProductList.getOrDefault(cartRespone.getProductCode(), 0) + cartRespone.getQuantity());

               cartService.deleteById(key);
           }
       }

//        cartProductList.forEach((productCode, quantity) ->
//                System.out.println("Product Code: " + productCode + ", Quantity: " + quantity));

        for (String productCode : cartProductList.keySet()) {
//            int quantity = cartProductList.get(productCode);
//            System.out.println("Product Code: " + productCode + ", Quantity: " + quantity);
            System.out.println("code = " + productCode);

            OrderRequest orderRequest = new OrderRequest();
            orderRequest.setCustomerNumber(496);

            //1. Lưu order
            OrderDetailRequest orderDetailRequest = orderService.add(orderRequest);
            orderDetailRequest.setProductCode(productCode);
            orderDetailRequest.setQuantityOrdered(cartProductList.get(productCode));

            ProductResponse productResponseTmp = productSerice.findById(productCode);
            orderDetailRequest.setPriceEach(productResponseTmp.getBuyPrice());

            //2. lưu order detail
            orderDetailService.add(orderDetailRequest);

            //3. lưu sản phẩm
            productSerice.editWithOrder(orderDetailRequest);
        }

        resp.sendRedirect("cart");
    }
}
