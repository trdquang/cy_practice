package org.example.cafeweb.servlet.frontend.order;

import org.example.cafeweb.dto.request.OrderDetailRequest;
import org.example.cafeweb.dto.request.OrderRequest;
import org.example.cafeweb.dto.response.ProductResponse;
import org.example.cafeweb.service.IOrderDetailService;
import org.example.cafeweb.service.IOrderService;
import org.example.cafeweb.service.IProductSerice;
import org.example.cafeweb.service.impl.OrderDetailService;
import org.example.cafeweb.service.impl.OrderService;
import org.example.cafeweb.service.impl.ProductService;
import org.example.cafeweb.util.PathUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addOrder", value = "/addOrder")
public class ServletOrderAdd extends HttpServlet {
    private IProductSerice productSerice = new ProductService();
    private IOrderService orderService = new OrderService();
    private IOrderDetailService orderDetailService = new OrderDetailService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PathUtil.pathFE_jsp + "order-add.jsp");
        String id = req.getParameter("idProduct");
        ProductResponse productResponse = productSerice.findById(id);
//        System.out.println("name = " + productResponse.getProductName());

        req.setAttribute("product", productResponse);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProduct = req.getParameter("idProduct");
        int quantity =  Integer.parseInt(req.getParameter("quantity"));
        double price =  Double.parseDouble(req.getParameter("price"));

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setCustomerNumber(496);

        //1. Lưu order
        OrderDetailRequest orderDetailRequest = orderService.add(orderRequest);
        orderDetailRequest.setProductCode(idProduct);
        orderDetailRequest.setQuantityOrdered(quantity);
        orderDetailRequest.setPriceEach(price);

        //2. lưu order detail
        orderDetailService.add(orderDetailRequest);

        //3. lưu sản phẩm
        productSerice.editWithOrder(orderDetailRequest);


        resp.sendRedirect("order");
    }
}
