<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Phòng</title>
    <!-- Thêm Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/backend/css/admin_room_add.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>

<body>
<form class="form-container" action="admin_room_edit" method="POST" enctype="multipart/form-data">
    <h2>Sửa thông tin Phòng</h2>
    <div class="form-row">
        <div class="form-group col-md-6">
            <input type="hidden" name="id" value="${roomResponse.idRoom}">

            <label for="roomName">Tên phòng:</label>
            <input type="text" class="form-control" id="roomName" name="roomName" value="${roomResponse.name}" required>

            <label for="roomPrice1">Giá 1:</label>
            <input type="number" class="form-control" id="roomPrice1" name="roomPrice1" value="${roomResponse.price1}" required>

            <label for="roomPrice2">Giá 2:</label>
            <input type="number" class="form-control" id="roomPrice2" name="roomPrice2" value="${roomResponse.price2}" required>

            <input type="hidden" name="image" value="${roomResponse.image}">

            <label for="roomImage">Ảnh:</label>
            <input type="file" class="form-control" id="roomImage" name="roomImage" accept="image/*">
        </div>

        <div class="form-group col-md-6">
            <label for="hotel">Khách sạn</label>
            <select id="hotel" name="hotel" class="form-control" required>
                <option value="${roomResponse.idHotel}">${roomResponse.nameHotel}</option>
                <c:if test="${not empty hotelResponeList}">
                    <c:forEach var="hotelIt" items="${hotelResponeList}">
                        <option value="${hotelIt.idHotel}">${hotelIt.nameHotel}</option>
                    </c:forEach>
                </c:if>
            </select>

            <label for="active">Trạng thái</label>
            <select id="active" name="active" class="form-control" required>
                <option value="1">Hoạt động</option>
                <option value="2">Ẩn</option>
            </select>

            <!-- <button type="submit" class="btn btn-success mt-3">Gửi</button>
            <button type="button" class="btn btn-danger mt-3" onclick="window.history.back();">Quay Lại</button> -->
        </div>
    </div>
    <div style="text-align: center;">
        <button type="submit" class="btn btn-success mt-3">Gửi</button>
        <button type="button" class="btn btn-danger mt-3" onclick="window.history.back();">Quay Lại</button>
    </div>
</form>

<!-- Thêm jQuery và Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="assets/backend/js/js_hotel_add.js"></script>
</body>

</html>