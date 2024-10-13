package org.example.cafeweb.servlet.backend.product;

import org.example.cafeweb.dto.request.ProductRequest;
import org.example.cafeweb.dto.response.ProductResponse;
import org.example.cafeweb.service.IOrderService;
import org.example.cafeweb.service.IProductSerice;
import org.example.cafeweb.service.impl.OrderService;
import org.example.cafeweb.service.impl.ProductService;
import org.example.cafeweb.util.PathUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "productAdd-admin", value = "/productAdd-admin")
@MultipartConfig(
        fileSizeThreshold = 1024*1024*1,
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*100
)

public class ControllerProductAdd extends HttpServlet {
    private IProductSerice _productService = new ProductService();
    private IOrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProduct = req.getParameter("idProduct") != null ? req.getParameter("idProduct").strip() : "";

        ProductResponse productResponse = _productService.findById(idProduct);
        req.setAttribute("productResponse", productResponse);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PathUtil.pathBE_jsp + "product-add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName") != null ? req.getParameter("productName").strip() : "";
        String productLine = req.getParameter("productLine") != null ? req.getParameter("productLine").strip() : "";
        String productVendor = req.getParameter("productVendor") != null ? req.getParameter("productVendor").strip() : "";

        //---------------------xử lý ảnh
        Part filePart = req.getPart("file");
        String fileName = null;

        if (filePart != null && filePart.getSize() > 0) {
            fileName = filePart.getSubmittedFileName();

            // Đường dẫn lưu tệp
            String uploadPath = getServletContext().getRealPath("") + "uploads";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir(); // Tạo thư mục nếu không tồn tại
            filePart.write(uploadPath + File.separator + fileName); // Lưu tệp
        }
        //--------------------------------------------------------

        int quantityInStockStr = Integer.parseInt(req.getParameter("quantityInStock"));
        double buyPrice = Double.parseDouble(req.getParameter("buyPrice"));
        int status = Integer.parseInt(req.getParameter("status"));

        ProductRequest productRequest = new ProductRequest("", productName, productLine, productVendor, quantityInStockStr, buyPrice, fileName, status);

        _productService.add(productRequest);
        resp.sendRedirect("http://localhost:8081/cafe/product-admin");
    }
}
