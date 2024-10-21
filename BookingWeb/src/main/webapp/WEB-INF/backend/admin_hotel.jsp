<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Khách Sạn</title>
    <link rel="stylesheet" href="assets/backend/css/admin_hotel.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
<div class="container-fluid d-flex">
    <jsp:include page="/WEB-INF/backend/layout/navbar.jsp"/>
    <div class="col-10 main flex-fill bg-white ">

        <!-- ---------------search------------ -->
        <!-- <div class="search-container">
            <input type="text" class="form-control d-inline-block" style="width: 39%; display: inline;"
                placeholder="Tìm kiếm theo tên khách sạn">
            <button class="btn btn-success">Tìm kiếm</button>
        </div> -->

        <div class="text-right" style="margin-top: 100px;">
            <a href="http://localhost:8081/booking/admin_hotel_add" class="btn btn-success">Thêm khách sạn</a>
        </div>

        <!-- ---------------------table dữ liệu -->
        <table class="table table-bordered">
            <thead class="thead-light">
            <tr>
                <th style="width: 10%;">STT</th>
                <th style="width: 20%;">Tên Khách Sạn</th>
                <th style="width: 45%;">Địa chỉ</th>
                <th style="width: 25%;">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="hotel" items="${hotelResponePagingList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/uploads/${hotel.image} " alt="Hình nền" width="50px" height="50px">
                            ${hotel.nameHotel}
                    </td>
                    <td>${hotel.nameAddress}</td>
                    <td>
                        <button class="btn btn-warning">
                            <a href="http://localhost:8081/booking/admin_hotel_edit?id=${hotel.idHotel}" style="text-decoration: none">Chỉnh Sửa</a>
                        </button>
                        <button class="btn btn-info">Active</button>
                        <button class="btn btn-danger">Hide</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <nav aria-label="Page navigation" style="display: flex; justify-content: flex-end; margin-right: 40px;">
            <ul class="pagination">
                <li class="page-item <c:if test="${page == 1}">disabled</c:if>">
                    <a class="page-link" href="http://localhost:8081/booking/admin_hotel?page=${page - 1}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo; Prev</span>
                    </a>
                </li>
                <c:forEach var="i" begin="1" end="${totalPage}">
                    <li class="page-item <c:if test="${i == page}">active</c:if>">
                        <a class="page-link" href="?page=${i}">${i}</a>
                    </li>
                </c:forEach>
                <li class="page-item <c:if test="${page == totalPage}">disabled</c:if>">
                    <a class="page-link" href="http://localhost:8081/booking/admin_hotel?page=${page + 1}"
                       aria-label="Next">
                        <span aria-hidden="true">Next &raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>

    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
