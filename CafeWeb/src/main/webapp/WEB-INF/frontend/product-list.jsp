<%@ page import="org.example.cafeweb.dto.response.ProductResponse" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
    <%--    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>--%>

    <%--    <link rel="stylesheet" href="assets/bootstrap_5/css/bootstrap.min.css">--%>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/awesome_4/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/frontend/css/cart.css">

    <style>
        .product-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .product-card {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin: 10px;
            width: calc(25% - 20px); /* 5 sản phẩm trên mỗi hàng */
            box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s; /* Hiệu ứng chuyển đổi */
        }

        .product-card:hover {
            transform: scale(1.05); /* Phóng to khi hover */
        }

        .product-card img {
            width: 100%; /* Chiếm 100% chiều rộng */
            height: 150px; /* Chiều cao cố định */
            object-fit: cover; /* Cắt bớt ảnh nếu cần */
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/frontend/layout/header.jsp"/>
<div id="main_product">
    <div class="container ">

        <div style="display: flex; align-items: center;" class="container mt-3">
            <div class="col-4">
                <form action="product" method="get" class="mb-4">
                    <div class="col-md-2">
                        <select id="productLine" style="width: 200px;" name="productLine" class="form-control"
                                onchange="this.form.submit()">
                            <c:if test="${not empty nameLine}">
                                <option value="${nameLine}" selected>${nameLine}</option>
                            </c:if>
                            <option value="All">All</option>
                            <c:forEach var="line" items="${listProductLine}">
                                <option value="${line}">${line}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>

            <div class="col-4">
                <form id="searchForm" action="product" method="get" class="mb-4">
                    <div class="input-group">
                        <div class="col-md-8">
                            <input type="text" placeholder="Search" id="nameSearch" name="name" class="form-control"
                                   aria-label="Search">
                            <input type="hidden" value="${nameLine}" name="productLine">
                        </div>
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="submit">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <%--    <div class="text-right mb-3">--%>
        <%--        <a href="addProduct?id=${product.productCode}" class="btn btn-success">Add Product</a>--%>
        <%--    </div>--%>

        <div class="product-container">
            <c:forEach var="product" items="${listProduct}">
                <div class="product-card">
                        <%--         hình ảnh       --%>
                    <div class="mb-3">
                            <%--                        <label>Image:</label>--%>
                        <img id="productImage"
                             src="${pageContext.request.contextPath}/uploads/${product.image != null && !product.image.isEmpty() ? product.image : 'noimage.png'}"
                             alt="Product Image"
                            <%--                             style="width:100px;height:auto;"--%>
                        >
                    </div>

                        <%--                <img src="https://picsum.photos/200?random=${product.productCode}" alt="Product Image" />--%>
                    <p>${product.productName}</p>
                    <p>Line: ${product.productLine}</p>
                    <p>Quantity: ${product.quantityInStock}</p>
                    <p>Price: ${product.buyPrice}</p>
                    <button class="btn btn-warning">
                        <a href="addOrder?idProduct=${product.productCode}" class="text-white"
                           style="color: blue">Mua</a>
                    </button>
                    <button class="btn btn-warning">
                        <a href="addCart?idProduct=${product.productCode}" class="text-white"
                           style="color: green">Giỏ</a>
                    </button>

                    <button class="btn btn-warning">
                        <a href="##" class="text-white"
                           style="color: green">
                            <p onclick="conunt_cart()">Thêm-giỏ</p>
                        </a>

                    </button>

                </div>
            </c:forEach>
        </div>
    </div>
</div>
<div id="pagination">
</div>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>--%>
<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>--%>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

<script src="assets/frontend/js/jsIndex.js"></script>
<script>
    function previewImage(event) {
        const file = event.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function (e) {
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
