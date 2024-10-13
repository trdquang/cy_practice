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
    <h2 class="text-center">Thêm Sản Phẩm Mới</h2>
    <form action="productAdd-admin" method="post" enctype="multipart/form-data">
<%--        <div class="mb-3">--%>
<%--            <label for="productCode" class="form-label">Mã Sản Phẩm</label>--%>
<%--            <input type="text" class="form-control" id="productCode" name="productCode" required>--%>
<%--        </div>--%>
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
            <label for="status" class="form-label">Trạng Thái</label>
            <select class="form-select" id="status" name="status" required>
                <option value="1">Hoạt Động</option>
                <option value="0">Không Hoạt Động</option>
            </select>
        </div>

        <div class="mb-3">
            <label>Choose a file</label>
            <input type="file" name="file" accept="image/*" onchange="previewImage(event)" />
        </div>
        <img id="imagePreview" src="" alt="Image Preview" style="display: none; width: 50px; height: 50px; margin-top: 10px;" />

        <button type="submit" class="btn btn-primary">Thêm Sản Phẩm</button>
        <a href="http://localhost:8081/cafe/product-admin" class="btn btn-secondary">Trở Lại</a>
    </form>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
<script>
    function previewImage(event) {
        const file = event.target.files[0];
        const reader = new FileReader();

        reader.onload = function(e) {
            const imagePreview = document.getElementById('imagePreview');
            imagePreview.src = e.target.result;
            imagePreview.style.display = 'block'; // Hiển thị ảnh
        }

        if (file) {
            reader.readAsDataURL(file);
        }
    }
</script>
</body>
</html>
