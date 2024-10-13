<%@ page import="org.example.cafeweb.dto.response.OrderDetailResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order History</title>
    <link rel="stylesheet" href="assets/bootstrap_5/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/awesome_4/css/font-awesome.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .order-container {
            max-width: 700px;
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
    <script>
        function confirmDelete(idCart) {
            if (confirm("Bạn có muốn xóa?")) {
                window.location.href = '/cafe/deleteCart?idCart=' + idCart; // Thay đổi URL cho phù hợp
            }
        }

        function confirmPurchase(idCart) {
            if (confirm("Bạn có muốn mua?")) {
                window.location.href = '/cafe/deleteCart?idCart=' + idCart; // Thay đổi URL cho phù hợp
            }
        }
        function toggleBuyButton() {
            const checkboxes = document.querySelectorAll('input[name="selectedCartIds"]:checked');
            const buyButton = document.getElementById('buyButton');
            buyButton.style.display = checkboxes.length > 0 ? 'block' : 'none';
        }

        function calculateTotal() {
            let total = 0;
            const checkboxes = document.querySelectorAll('input[name="selectedCartIds"]:checked');

            checkboxes.forEach((checkbox) => {
                const cartCard = checkbox.closest('.order-card');
                const price = parseFloat(cartCard.querySelector('.order-header span.text-muted').textContent.replace('$', ''));
                const quantity = parseInt(cartCard.querySelector('.order-item span:nth-child(2)').textContent.replace('Qty: ', ''));
                total += price * quantity;
            });

            document.getElementById('totalAmount').textContent = `Tổng tiền: $${total.toFixed(2)}`;
        }
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/frontend/layout/header.jsp" />
<div class="order-container">
    <h2 class="text-center mb-4">Order History</h2>
    <form action="buyCart" method="post">
        <c:forEach var="cart" items="${cartResponeList}">
            <div class="order-card">
                <img src="https://picsum.photos/80?random=${cart.productCode}" alt="Product Image" class="order-image" />
                <div class="order-details">
                    <div class="order-header">
                        <h5>${cart.productName}</h5>
                        <span class="text-muted">$${cart.priceEach}</span>
                    </div>
                    <div class="order-item">
                        <span>Customer: ${cart.customerName}</span>
                        <span>Qty: ${cart.quantity}</span>
                    </div>
                </div>
                <div class="button-container">
                    <input type="checkbox" name="selectedCartIds" value="${cart.cartId}" onclick="toggleBuyButton()"> Chọn
<%--                    <input type="checkbox" name="selectedCartIds" value="${cart.cartId}"> Chọn--%>
<%--                    <button class="btn btn-primary" onclick="confirmPurchase('${cart.cartId}')">Mua</button>--%>
                    <button class="btn btn-danger" onclick="confirmDelete('${cart.cartId}')">Xóa</button>
                </div>
            </div>
        </c:forEach>
        <div id="totalAmount" class="text-center mb-4" style="font-weight: bold;">Tổng tiền: $0.00</div>
        <button type="submit" id="buyButton" class="btn btn-success" style="display: none;">Mua</button>
    </form>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
