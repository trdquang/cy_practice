<%--
  Created by IntelliJ IDEA.
  User: songt
  Date: 10/10/2024
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assets/bootstrap_5/css/bootstrap.min.css">

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
    </style>
</head>
<body>
<header class="header">
    <div class="container">
        <div class="d-flex align-items-center">
            <div class="logo">
                <a href="#"><img src="uploads/product.png" alt="Logo" class="logo"></a>
            </div>
            <nav class="navbar navbar-expand-lg">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8081/cafe/product-admin">Sản phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8081/cafe/order-admin">Đơn hàng</a>
                    </li>
                </ul>
            </nav>
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
</body>
</html>
