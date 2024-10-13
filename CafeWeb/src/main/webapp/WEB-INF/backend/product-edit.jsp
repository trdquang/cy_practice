<%@ page import="org.example.cafeweb.dto.response.ProductResponse" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Thêm Sản Phẩm</title>
  <link rel="stylesheet" href="assets/bootstrap_5/css/bootstrap.min.css">
  <style>
    .container {
      margin-top: 50px;
    }
  </style>
</head>
<body>
<div class="container">
  <h2 class="text-center">Sửa sản phẩm</h2>
  <form action="productEdit-admin" method="post" enctype="multipart/form-data">
    <%--        <div class="mb-3">--%>
    <%--            <label for="productCode" class="form-label">Mã Sản Phẩm</label>--%>
    <%--            <input type="text" class="form-control" id="productCode" name="productCode" required>--%>
    <%--        </div>--%>
    <input type="hidden" name="idProduct" value="${idProduct}">
    <div class="mb-3">
      <label for="productName" class="form-label">Tên Sản Phẩm</label>
      <input type="text" class="form-control" id="productName" name="productName" required value="${productResponse.productName}">
    </div>
    <div class="mb-3">
      <label for="productLine" class="form-label">productLine</label>
      <input type="text" class="form-control" id="productLine" name="productLine" value="${productResponse.productLine}" required>
    </div>
    <div class="mb-3">
      <label for="productVendor" class="form-label">product Vendor</label>
      <input type="text" class="form-control" id="productVendor" name="productVendor" value="${productResponse.productVendor}" required>
    </div>
    <div class="mb-3">
      <label for="quantityInStock" class="form-label">Số Lượng</label>
      <input type="number" class="form-control" id="quantityInStock" name="quantityInStock" value="${productResponse.quantityInStock}" required>
    </div>
    <div class="mb-3">
      <label for="buyPrice" class="form-label">Giá Mua</label>
      <input type="number" class="form-control" id="buyPrice" name="buyPrice" step="0.01" value="${productResponse.buyPrice}"  required>
    </div>

      <div class="mb-3">
        <label>Image:</label>
        <img id="productImage" src="${pageContext.request.contextPath}/uploads/${productResponse.image}" alt="Product Image" style="width:100px;height:auto;">
      </div>
      <div class="mb-3">
        <label>Choose a new file (optional):</label>
        <input type="file" name="file" onchange="previewImage(event)" />
        <input type="hidden" name="currentImageFileName" value="${productResponse.image}"> <!-- Tên tệp hiện tại -->
      </div>

    <div class="mb-3">
      <label for="status" class="form-label">Trạng Thái</label>
      <select class="form-select" id="status" name="status" required>
        <option value="1">Hoạt Động</option>
        <option value="0">Không Hoạt Động</option>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Thêm Sản Phẩm</button>
    <a href="http://localhost:8081/cafe/product-admin" class="btn btn-secondary">Trở Lại</a>
  </form>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
<script>
  function previewImage(event) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = function(e) {
        // Cập nhật src của img để hiển thị ảnh mới
        document.getElementById('productImage').src = e.target.result;
      };
      reader.readAsDataURL(file); // Đọc tệp dưới dạng URL
    } else {
      // Nếu không có tệp, có thể đặt lại src về ảnh cũ
      document.getElementById('productImage').src = '${pageContext.request.contextPath}/uploads/${productResponse.image}';
    }
  }
</script>
</body>
</html>
