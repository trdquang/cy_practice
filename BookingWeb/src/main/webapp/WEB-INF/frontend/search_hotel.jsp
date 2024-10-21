<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prime Hotels</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/frontend/css/search_hotel.css">
</head>
<body>
<!-- -------------------header -->
<jsp:include page="/WEB-INF/frontend/layout/header.jsp"/>

<form class="form-group d-flex align-items-center" style="width: 100%; margin-top: 10px" method="get" name="search_hotel">
    <input type="hidden" name="locationName" value="${locationName}">
    <input type="hidden" name="startDate" value="${startDate}">
    <input type="hidden" name="endDate" value="${endDate}">

    <label for="selectHotel" class="mr-2" >Sắp xếp:</label>

    <!-- Thêm lớp Bootstrap cho select -->
    <select class="form-control mr-2" id="selectHotel" name="sortBy" style="width: 9%">
        <option value="sortNone">Không</option>
        <option value="sortName">Tên</option>
        <option value="sortPrice">Giá</option>
    </select>

    <!-- Thêm lớp Bootstrap cho button -->
    <button type="submit" class="btn btn-primary">Lọc</button>
</form>


<c:forEach var="room" items="${roomResponseList}">
    <div class="hotel_view_card">
            <%--    <img src="/images/hotel.jpg" alt="Hình ảnh khách sạn">--%>
        <img src="${pageContext.request.contextPath}/uploads/${room.image} " alt="Hình nền" width="50px" height="50px">
        <div>
            <div style="margin-top: auto;">
                <div><strong>Tên khách sạn:</strong> ${room.name}</div>
                <div><strong>Địa điểm:</strong> ${room.address}</div>
                    <%--            <div><strong>Dịch vụ:</strong> Wifi, Hồ bơi, Spa</div>--%>
            </div>
            <div style="margin-top: 100px;">
                <div><strong>Giá:</strong> ${room.price2} VNĐ</div>
            </div>
        </div>

        <div style="margin-left: auto; margin-top: auto; width: 25%;
        height: 8%; border-radius: 10px; display: flex; ">
            <button style="background-color: rgb(195, 27, 27); color: #f5f5f5; border-radius: 20px; border: none; padding: 5px">
                <a href="http://localhost:8081/booking/room_detail?idRoom=${room.idRoom}&startDate=${startDate}&endDate=${endDate}" style="text-decoration: none">Xem chi tiết</a>
            </button>
            <button style="margin-left: 20px ;background-color: rgb(175, 53, 197); color: #f5f5f5; border-radius: 20px; border: none; padding: 5px">
                Đặt phòng
            </button>
        </div>

    </div>
</c:forEach>

<nav aria-label="Page navigation" style="display: flex; justify-content: center; margin-top: 20px;">
    <ul class="pagination">
        <li class="page-item <c:if test="${page == 1}">disabled</c:if>">
            <a class="page-link"
               href="http://localhost:8081/booking/search_hotel?locationName=${locationName}&startDate=${startDate}&endDate=${endDate}&page=${page - 1}&sortBy=${sortBy}"
               aria-label="Previous">
                <span aria-hidden="true">&laquo; Prev</span>
            </a>
        </li>
        <c:forEach var="i" begin="1" end="${totalPage}">
            <li class="page-item <c:if test="${i == page}">active</c:if>">
                <a class="page-link"
                   href="http://localhost:8081/booking/search_hotel?locationName=${locationName}&startDate=${startDate}&endDate=${endDate}&page=${i}&sortBy=${sortBy}">${i}</a>
            </li>
        </c:forEach>
        <li class="page-item <c:if test="${page == totalPage}">disabled</c:if>">
            <a class="page-link"
               href="http://localhost:8081/booking/search_hotel?locationName=${locationName}&startDate=${startDate}&endDate=${endDate}&page=${page + 1}&sortBy=${sortBy}"
               aria-label="Next">
                <span aria-hidden="true">Next &raquo;</span>
            </a>
        </li>
    </ul>
</nav>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
