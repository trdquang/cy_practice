<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Khách Sạn</title>
    <link rel="stylesheet" href="assets/backend/css/admin_hotel_add.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>

<body>

<form action="admin_hotel_edit" method="post" class="form-container" enctype="multipart/form-data">
<%--    <div class="form-container">--%>
        <h2>Chỉnh sửa Khách Sạn</h2>
        <div class="form-column">
            <input type="hidden" name="id_hotel" value="${hotelRespone.idHotel}">
            <input type="hidden" name="image" value="${hotelRespone.image}">

            <label for="hotelName">Tên Khách Sạn:</label>
            <input type="text" id="hotelName" name="hotelName" required value="${hotelRespone.nameHotel}">

            <label for="hotelImage">Ảnh:</label>
            <input type="file" id="hotelImage" name="hotelImage" accept="image/*">
        </div>

        <div class="form-column">
            <label for="province">Tỉnh:</label>
            <select id="province" name="province" required onchange="onChangeSelectLocation(2, this.value)">
                <option value="0">Chọn tỉnh</option>
                <c:forEach var="prIt" items="${listProvince}">
                    <option value="${prIt.id}">${prIt.name}</option>
                </c:forEach>
            </select>

            <label for="district">Huyện:</label>
            <select id="district" name="district" required onchange="onChangeSelectLocation(3, this.value)">
                <option value="0">Chọn huyện</option>
            </select>

            <label for="commune">Xã:</label>
            <select id="commune" name="commune" required>
                <option value="0">Chọn xã</option>
            </select>

            <button type="submit" class="submit">Gửi</button>
            <button type="button" class="back" onclick="window.history.back();">Quay Lại</button>
        </div>
<%--    </div>--%>

</form>
<script src="assets/backend/js/js_hotel_add.js"></script>
</body>

</html>