<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>Datatables - Kaiadmin Bootstrap 5 Admin Dashboard</title>
    <meta
            content="width=device-width, initial-scale=1.0, shrink-to-fit=no"
            name="viewport"
    />
    <link
            rel="icon"
            href="assets/backend/img/kaiadmin/favicon.ico"
            type="image/x-icon"
    />

    <!-- Fonts and icons -->
    <script src="assets/backend/js/plugin/webfont/webfont.min.js"></script>
    <script>
        WebFont.load({
            google: {families: ["Public Sans:300,400,500,600,700"]},
            custom: {
                families: [
                    "Font Awesome 5 Solid",
                    "Font Awesome 5 Regular",
                    "Font Awesome 5 Brands",
                    "simple-line-icons",
                ],
                urls: ["assets/backend/css/fonts.min.css"],
            },
            active: function () {
                sessionStorage.fonts = true;
            },
        });
    </script>

    <!-- CSS Files -->
    <link rel="stylesheet" href="assets/backend/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/backend/css/plugins.min.css"/>
    <link rel="stylesheet" href="assets/backend/css/kaiadmin.min.css"/>

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link rel="stylesheet" href="assets/backend/css/demo.css"/>
</head>
<body>
<div class="wrapper">
    <!-- Sidebar -->
    <jsp:include page="/WEB-INF/backend/layout/slidebar.jsp"></jsp:include>
    <!-- End Sidebar -->

    <div class="main-panel">
        <jsp:include page="/WEB-INF/backend/layout/header.jsp"></jsp:include>

        <div class="container">
            <div class="page-inner">
                <div class="page-header">
                    <h3 class="fw-bold mb-3">DataTables.Net</h3>
                    <ul class="breadcrumbs mb-3">
                        <li class="nav-home">
                            <a href="#">
                                <i class="icon-home"></i>
                            </a>
                        </li>
                        <li class="separator">
                            <i class="icon-arrow-right"></i>
                        </li>
                        <li class="nav-item">
                            <a href="#">Tables</a>
                        </li>
                        <li class="separator">
                            <i class="icon-arrow-right"></i>
                        </li>
                        <li class="nav-item">
                            <a href="#">Datatables</a>
                        </li>
                    </ul>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <div class="d-flex align-items-center">
                                    <h4 class="card-title">Add Row</h4>
                                    <button
                                            class="btn btn-primary btn-round ms-auto"
                                            data-bs-toggle="modal"
                                            data-bs-target="#addRowModal">
                                        <i class="fa fa-plus"></i>
                                        Add Row
                                    </button>
                                </div>
                            </div>
                            <div class="card-body">
                                <!-- Modal -->
                                <jsp:include page="/WEB-INF/backend/layout/modal_user_add.jsp"></jsp:include>

                                <div class="table-responsive">
                                    <table
                                            id="add-row"
                                            class="display table table-striped table-hover"
                                    >
                                        <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Position</th>
                                            <th>Office</th>
                                            <th style="width: 10%">Action</th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <tr>
                                            <td>Garrett Winters</td>
                                            <td>Accountant</td>
                                            <td>Tokyo</td>
                                            <td>
                                                <div class="form-button-action">
                                                    <button
                                                            type="button"
                                                            data-bs-toggle="tooltip"
                                                            title=""
                                                            class="btn btn-link btn-primary btn-lg"
                                                            data-original-title="Edit Task"
                                                    >
                                                        <i class="fa fa-edit"></i>
                                                    </button>
                                                    <button
                                                            type="button"
                                                            data-bs-toggle="tooltip"
                                                            title=""
                                                            class="btn btn-link btn-danger"
                                                            data-original-title="Remove"
                                                    >
                                                        <i class="fa fa-times"></i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/WEB-INF/backend/layout/footer.jsp"></jsp:include>
    </div>

</div>
<!--   Core JS Files   -->
<script src="assets/backend/js/core/jquery-3.7.1.min.js"></script>
<script src="assets/backend/js/core/popper.min.js"></script>
<script src="assets/backend/js/core/bootstrap.min.js"></script>

<!-- jQuery Scrollbar -->
<script src="assets/backend/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<!-- Datatables -->
<script src="assets/backend/js/plugin/datatables/datatables.min.js"></script>
<!-- Kaiadmin JS -->
<script src="assets/backend/js/kaiadmin.min.js"></script>
<!-- Kaiadmin DEMO methods, don't include it in your project! -->
<script src="assets/backend/js/setting-demo2.js"></script>

<script src="assets/backend/js/slidebar.js"></script>
<script src="assets/backend/js/user.js"></script>
<script>
    // Gọi hàm selectSlideBar với tham số dựa trên trang hiện tại
    selectSlideBar("user");
</script>

</body>
</html>
