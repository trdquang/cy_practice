<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi Tiết Khách Sạn</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/frontend/css/room_details.css">
</head>

<body>
<jsp:include page="/WEB-INF/frontend/layout/header.jsp"/>

<div class="container" style="margin-top: 20px">
    <!-- Dòng 1: Ảnh và thông tin mô tả khách sạn -->
    <div class="hotel-info">
        <div class="image-container">
            <img src="${pageContext.request.contextPath}/uploads/${roomResponse.image} " alt="Hình nền" >
        </div>
        <div class="description">
            <h3>Khách sạn: ${roomResponse.nameHotel}</h3>
            <h3>Phòng: ${roomResponse.name}</h3>
            <p><strong>Địa chỉ:</strong> ${roomResponse.address}</p>
        </div>
    </div>

    <!-- Dòng 2: Dịch vụ và giá tiền  -->
    <div class="service-info">
        <div class="service-list">
            <h5>Dịch Vụ</h5>
            <ul>
                <li>Wifi miễn phí</li>
                <li>Hồ bơi</li>
                <li>Nhà hàng</li>
                <li>Gym</li>
            </ul>
        </div>

        <form class="date-check" method="post" action="room_detail">
            <h5>Thông Tin Đặt Phòng</h5>
            <input type="hidden" name="idRoom" value="${roomResponse.idRoom}">
            <div>
                <label for="checkin">Ngày Check-in:</label>
                <input type="text" id="checkin" value="${startDate}" name="startDate" readonly>
            </div>
            <div>
                <label for="checkout">Ngày Check-out:</label>
                <input type="text" id="checkout" value="${endDate}" name="endDate" readonly>
            </div>
            <div class="total-price">
                <p>Tổng Tiền: ${price} VNĐ</p>
                <input type="hidden" name="price" value="${price}">
<%--                <input type="hidden" name="idRoom" value="${price}">--%>
            </div>
            <button class="book-button">Đặt Phòng</button>
        </form>
    </div>

    <!-- Phần review -->
    <div class="reviews-section">
        <h5>Review</h5>
        <h5>Chưa có lượt review nào</h5>

        <div class="review-item">
            <div class="review-header">
                <span class="reviewer-name"><strong>Nguyễn Văn A</strong></span>
                <span class="review-date">- 10/10/2024</span>
            </div>
            <div class="review-rating">
                <span>★★★★★</span>
            </div>
            <div class="review-content">
                <p>Khách sạn rất đẹp, phòng sạch sẽ và tiện nghi. Nhân viên thân thiện, dịch vụ tuyệt vời. Chắc chắn sẽ quay lại!</p>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS và Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
