<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--  <link rel="stylesheet" href="/assets/bootstrap_5/css/bootstrap.min.css">--%>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Đường dẫn đến tệp CSS của Font Awesome -->
    <link rel="stylesheet" href="/assets/awesome_4/css/font-awesome.min.css">

    <style>
        .header {
            background-color: #f8f9fa;
            padding: 10px 0;
        }

        .logo img {
            max-height: 50px;
        }

        .navbar {
            margin-left: 20px; /* Thêm khoảng cách bên trái cho menu */
        }

        .header-icons {
            margin-left: auto; /* Đẩy các biểu tượng sang bên phải */
        }

        .header-icons a {
            margin-left: 15px; /* Khoảng cách giữa các biểu tượng */
        }

        h4 {
            margin-right: 20px; /* Khoảng cách giữa các thẻ h4 */
            cursor: pointer; /* Để hiện thị con trỏ khi di chuột */
        }

        .cart-icon {
            position: relative;
            display: inline-block;
            font-size: 24px; /* Kích thước biểu tượng */
            color: #333; /* Màu sắc của biểu tượng */
        }

        .cart-count {
            position: absolute;
            top: -5px; /* Vị trí của số lượng */
            right: -10px; /* Vị trí của số lượng */
            background-color: red; /* Màu nền cho số lượng */
            color: white; /* Màu chữ */
            border-radius: 50%; /* Đường viền tròn */
            padding: 2px 6px; /* Khoảng cách bên trong */
            font-size: 12px; /* Kích thước chữ */
            font-weight: bold; /* Đậm chữ */
        }

    </style>
</head>
<body>
<header class="header">
    <div class="container">
        <div class="d-flex align-items-center">
            <div class="logo">
                <a href="#"><img src="uploads/product.png" alt="Logo" class="logo"></a>
            </div>

            <h4 onclick="select_option(0)">Trang chủ</h4>
            <h4 onclick="select_option(1)">Giỏ hàng</h4>
            <h4 onclick="select_option(2)">Đơn hàng</h4>

            <div class="cart-icon">
                <i class="fa fa-shopping-cart"></i>
                <span class="cart-count">3</span> <!-- Số lượng sản phẩm trong giỏ -->
            </div>


            <div class="header-icons ml-auto">
                <a href="#" title="User" style="font-size: 24px; color: blue;">
                    <i class="fa fa-user" aria-hidden="true"></i>
                </a>

                <a href="#" title="Logout" style="font-size: 24px; color: red;">
                    <i class="fa fa-sign-out" aria-hidden="true"></i>
                </a>

            </div>
        </div>
    </div>
</header>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

<script src="assets/frontend/js/jsIndex.js"></script>
</body>
</html>
