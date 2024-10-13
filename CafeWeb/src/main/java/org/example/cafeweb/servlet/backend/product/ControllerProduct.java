package org.example.cafeweb.servlet.backend.product;

import org.example.cafeweb.dto.response.ProductResponse;
import org.example.cafeweb.search.ProductSearch;
import org.example.cafeweb.service.IOrderService;
import org.example.cafeweb.service.IProductSerice;
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
import java.util.List;
import java.util.Set;

@WebServlet(name = "admin-product", value = "/product-admin")
public class ControllerProduct extends HttpServlet {
    private IProductSerice _productService = new ProductService();
    private IOrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameSearch = req.getParameter("name") != null ? req.getParameter("name").strip() : "";
        String nameLine = req.getParameter("productLine") != null ? req.getParameter("productLine").strip() : "All";
        String nameVendor = req.getParameter("productVendor") != null ? req.getParameter("productVendor").strip() : "All";

        ProductSearch productSearch = new ProductSearch();
        productSearch.setProductName(nameSearch);
        productSearch.setProductLine(nameLine.equalsIgnoreCase("All") ? "" : nameLine);
        productSearch.setProductVendor(nameVendor.equalsIgnoreCase("All") ? "" : nameVendor);

        List<ProductResponse> listProduct = _productService.getAll(productSearch, 0);
        Set<String> lineSet = _productService.getAllProductLine(0);
        Set<String> productVendor = _productService.getAllProductVendor(0);

        req.setAttribute("listProduct", listProduct);
        req.setAttribute("listProductLine", lineSet);
        req.setAttribute("listProductVendor", productVendor);
        req.setAttribute("nameLine", nameLine);
        req.setAttribute("nameVendor", nameVendor);

//        System.out.println("Nảm vendor = " + nameVendor);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PathUtil.pathBE_jsp + "product-list.jsp");
        requestDispatcher.forward(req, resp);
    }

}
