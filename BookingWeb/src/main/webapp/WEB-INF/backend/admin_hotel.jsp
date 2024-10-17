<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Khách Sạn</title>
    <link rel="stylesheet" href="assets/backend/css/admin_hotel.css">
</head>

<body>
<div class="container">
    <jsp:include page="/WEB-INF/backend/layout/navbar.jsp" />
    <div class="main">
        <div class="search-container">
            <input type="text" placeholder="Tìm kiếm theo tên khách sạn">
            <button>Tìm kiếm</button>
        </div>

        <%--   Thêm sản phẩm     ------------%>
        <div style="text-align: right;">
            <a href="" style="background-color: #45a049; border-radius: 5px;
                color: white; padding: 10px; text-decoration: none;">
                Thêm sản phẩm
            </a>
        </div>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Tên Khách Sạn</th>
                <th>Giá</th>
                <th>Hành Động</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Khách Sạn ABC</td>
                <td>1,000,000 VNĐ</td>
                <td>
                    <button style="background-color: #6ca730; padding: 8px; border-radius: 5px; color: rgb(69, 24, 24);">Chỉnh Sửa</button>
                    <button style="background-color: #f6e3b4; padding: 8px; border-radius: 5px; color: rgb(69, 24, 24)">Hoạt Động</button>
                    <button style="background-color: #e2b1b1; padding: 8px; border-radius: 5px; color: rgb(69, 24, 24)">Ngừng Hoạt Động</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>Khách Sạn DEF</td>
                <td>800,000 VNĐ</td>
                <td>
                    <button style="background-color: #6ca730; padding: 8px; border-radius: 5px; color: rgb(69, 24, 24)">Chỉnh Sửa</button>
                    <button style="background-color: #f6e3b4; padding: 8px; border-radius: 5px; color: rgb(69, 24, 24)">Hoạt Động</button>
                    <button style="background-color: #e2b1b1; padding: 8px; border-radius: 5px; color: rgb(69, 24, 24)">Ngừng Hoạt Động</button>
                </td>
            </tr>
            <!-- Thêm nhiều hàng nếu cần -->
            </tbody>
        </table>

        <div class="pagination">
            <button>1</button>
            <button>2</button>
            <button>3</button>
            <button>4</button>
            <!-- Thêm các nút phân trang nếu cần -->
        </div>
    </div>
</div>
</body>

</html>
