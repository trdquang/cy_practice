<%@ page import="org.example.cafeweb.dto.response.ProductResponse" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Admin</title>
    <link rel="stylesheet" href="assets/bootstrap_5/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/awesome_4/css/font-awesome.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>
        .table-container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/backend/layout/header.jsp" />
<div class="container">
    <div class="d-flex align-items-center justify-content-between mt-3">
        <form action="product-admin" method="get" class="mb-4">
            <label for="productVendor">Product Vendor</label>
            <select id="productVendor" name="productVendor" class="form-control" onchange="this.form.submit()">
                <c:if test="${not empty nameVendor}">
                    <option value="${nameVendor}" selected>${nameVendor}</option>
                </c:if>
                <option value="All">All</option>
                <c:forEach var="line" items="${listProductVendor}">
                    <option value="${line}">${line}</option>
                </c:forEach>
            </select>
            <input type="hidden" value="${nameLine}" name="productLine"> <!-- Để giữ nameLine -->
            <input type="hidden" value="${nameVendor}" name="productVendor">
        </form>


        <form action="product-admin" method="get" class="mb-4">
            <label for="productLine">Product Line</label>
            <select id="productLine" name="productLine" class="form-control" onchange="this.form.submit()">
                <c:if test="${not empty nameLine}">
                    <option value="${nameLine}" selected>${nameLine}</option>
                </c:if>
                <option value="All">All</option>
                <c:forEach var="line" items="${listProductLine}">
                    <option value="${line}">${line}</option>
                </c:forEach>
            </select>
            <input type="hidden" value="${nameLine}" name="productLine"> <!-- Để giữ nameLine -->
            <input type="hidden" value="${nameVendor}" name="productVendor">
        </form>



        <form id="searchForm" action="product-admin" method="get" class="mb-4">
            <div class="input-group">
                <input type="text" placeholder="Search" id="nameSearch" name="name" class="form-control" aria-label="Search">
                <input type="hidden" value="${nameLine}" name="productLine">
                <input type="hidden" value="${nameVendor}" name="productVendor">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">Search</button>
                </div>
            </div>
        </form>
    </div>
    <a href="http://localhost:8081/cafe/productAdd-admin" class="btn btn-secondary">Thêm</a>
    <div class="table-container">
        <table class="table table-bordered">
            <thead class="thead-light">
            <tr>
                <th scope="col">Product Code</th>
                <th scope="col">Vendor Name</th>
                <th scope="col">Product Name</th>
                <th scope="col">Line</th>
                <th scope="col">Quantity</th>
                <th scope="col">Price</th>
                <th scope="col">Active</th>
                <th scope="col" class="text-center">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${listProduct}">
                <tr>
                    <td>${product.productCode}</td>
                    <td>${product.productVendor}</td>
                    <td>${product.productName}</td>
                    <td>${product.productLine}</td>
                    <td>${product.quantityInStock}</td>
                    <td>${product.buyPrice}</td>
                    <td>${product.active}</td>
                    <td class="text-center">
                        <a href="#" class="btn btn-info" onclick="showAlert('Edit', 'Tiếp tục ?', 'productEdit-admin?idProduct=${product.productCode}')">Edit</a>
<%--                        <a href="#" class="btn btn-secondary" onclick="showAlert('Inactive', 'Tiếp tục ?', 'productEdit?idProduct=${product.productCode}')">Inactive</a>--%>
                        <a href="#" class="btn btn-secondary"
                           onclick="showAlert('Inactive', 'Tiếp tục ?',
                                   'productEdit-admin?idProduct=${product.productCode}&active=0&status=inactive')">Inactive</a>
                        <a href="#" class="btn btn-success"
                           onclick="showAlert('Activate', 'Tiếp tục ??',
                                   'productEdit-admin?idProduct=${product.productCode}&active=${product.active}&status=active')">Active</a>
                </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    function showAlert(title, text, redirectUrl) {
        Swal.fire({
            title: title,
            text: text,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, proceed!',
            cancelButtonText: 'No, cancel!',
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = redirectUrl;
            }
        });
    }
</script>
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
