<%@ page import="org.example.cafeweb.dto.response.OrderDetailResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order History</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .order-container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
        }
        .order-card {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 15px;
            margin-bottom: 15px;
            display: flex;
            align-items: center; /* Center align items vertically */
            transition: transform 0.2s;
        }
        .order-card:hover {
            transform: scale(1.02);
        }
        .order-image {
            width: 80px; /* Set a fixed width for the image */
            height: auto; /* Keep aspect ratio */
            border-radius: 5px;
            margin-right: 15px; /* Space between image and text */
        }
        .order-details {
            flex-grow: 1; /* Allow the details to take remaining space */
        }
        .order-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 10px; /* Space below header */
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/frontend/layout/header.jsp" />
<div class="order-container">
    <h2 class="text-center mb-4">Order History</h2>
    <c:forEach var="order" items="${orderResponses}">
        <div class="order-card">
<%--            <img src="https://picsum.photos/80?random=${order.productCode}" alt="Product Image" class="order-image" />--%>
            <img id="productImage"
                 src="${pageContext.request.contextPath}/uploads/${order.image != null && !order.image.isEmpty() ? order.image : 'noimage.png'}"
                 alt="Product Image"
                 width="50px" height="50px"
            >
            <div class="order-details">
                <div class="order-header">
                    <h5>${order.productName}</h5>
                    <span class="text-muted">$${order.priceEach}</span>
                </div>
                <div class="order-item">
                    <span>Customer: ${order.customerName}</span>
                    <span>Qty: ${order.quantityOrdered}</span>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

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
