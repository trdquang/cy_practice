<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/variable.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Dashboard</title>
    <meta content="width=device-width, initial-scale=1.0, shrink-to-fit=no" name="viewport" />
    <link rel="icon" href="assets/backend/img/kaiadmin/favicon.ico" type="image/x-icon" />

    <!-- Fonts and icons -->
    <script src="assets/backend/js/plugin/webfont/webfont.min.js"></script>
    <script>
        WebFont.load({
            google: { families: ["Public Sans:300,400,500,600,700"] },
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
    <link rel="stylesheet" href="assets/backend/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/backend/css/plugins.min.css" />
    <link rel="stylesheet" href="assets/backend/css/kaiadmin.min.css" />

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link rel="stylesheet" href="assets/backend/css/demo.css" />
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

                <%-- ----------------Xin chào--%>
                <div class="d-flex align-items-left align-items-md-center flex-column flex-md-row pt-2 pb-4">
                    <div>
                        <h3 class="fw-bold mb-3">Dashboard </h3>
                        <h6 class="op-7 mb-2">My website</h6>
                    </div>
                </div>

                <!-- //-------------Thanh icon--------------------------------- -->
                <div class="row">
                    <div class="col-sm-6 col-md-3">
                        <div class="card card-stats card-round">
                            <div class="card-body">
                                <div class="row align-items-center">
                                    <div class="col-icon">
                                        <div class="icon-big text-center icon-primary bubble-shadow-small">
                                            <i class="fas fa-users"></i>
                                        </div>
                                    </div>
                                    <div class="col col-stats ms-3 ms-sm-0">
                                        <div class="numbers">
                                            <p class="card-category">Visitors</p>
                                            <h4 class="card-title">1,294</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3">
                        <div class="card card-stats card-round">
                            <div class="card-body">
                                <div class="row align-items-center">
                                    <div class="col-icon">
                                        <div class="icon-big text-center icon-info bubble-shadow-small">
                                            <i class="fas fa-user-check"></i>
                                        </div>
                                    </div>
                                    <div class="col col-stats ms-3 ms-sm-0">
                                        <div class="numbers">
                                            <p class="card-category">Subscribers</p>
                                            <h4 class="card-title">1303</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3">
                        <div class="card card-stats card-round">
                            <div class="card-body">
                                <div class="row align-items-center">
                                    <div class="col-icon">
                                        <div class="icon-big text-center icon-success bubble-shadow-small">
                                            <i class="fas fa-luggage-cart"></i>
                                        </div>
                                    </div>
                                    <div class="col col-stats ms-3 ms-sm-0">
                                        <div class="numbers">
                                            <p class="card-category">Sales</p>
                                            <h4 class="card-title">$ 1,345</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3">
                        <div class="card card-stats card-round">
                            <div class="card-body">
                                <div class="row align-items-center">
                                    <div class="col-icon">
                                        <div class="icon-big text-center icon-secondary bubble-shadow-small">
                                            <i class="far fa-check-circle"></i>
                                        </div>
                                    </div>
                                    <div class="col col-stats ms-3 ms-sm-0">
                                        <div class="numbers">
                                            <p class="card-category">Order</p>
                                            <h4 class="card-title">576</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ----------------------------------------------------            kết thúc thống kê--------------- -->

                <!-- -------------------------------------------biểu đồ-------------------------------------- -->
                <div class="row">
                    <!-- Biểu đồ 1 -->
                    <div class="col-md-12">
                        <div class="card card-round">
                            <div class="card-header">
                                <div class="card-head-row">
                                    <div class="card-title">User Statistics</div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="chart-container" style="min-height: 375px">
                                    <canvas id="statisticsChart"></canvas>
                                </div>
                                <div id="myChartLegend"></div>
                            </div>
                        </div>
                    </div>

                    <!-- Hết biểu đồ 1 -->
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="card card-round">
                            <div class="card-header">
                                <div class="card-head-row card-tools-still-right">
                                    <h4 class="card-title">Users Geolocation</h4>
                                    <div class="card-tools">
                                        <button class="btn btn-icon btn-link btn-primary btn-xs">
                                            <span class="fa fa-angle-down"></span>
                                        </button>
                                        <button class="btn btn-icon btn-link btn-primary btn-xs btn-refresh-card">
                                            <span class="fa fa-sync-alt"></span>
                                        </button>
                                        <button class="btn btn-icon btn-link btn-primary btn-xs">
                                            <span class="fa fa-times"></span>
                                        </button>
                                    </div>
                                </div>
                                <p class="card-category">
                                    Map of the distribution of users around the world
                                </p>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="table-responsive table-hover table-sales">
                                            <table class="table">
                                                <tbody>
                                                <tr>
                                                    <td>
                                                        <div class="flag">
                                                            <img src="assets/backend/img/flags/id.png" alt="indonesia" />
                                                        </div>
                                                    </td>
                                                    <td>Indonesia</td>
                                                    <td class="text-end">2.320</td>
                                                    <td class="text-end">42.18%</td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <div class="flag">
                                                            <img src="assets/backend/img/flags/us.png" alt="united states" />
                                                        </div>
                                                    </td>
                                                    <td>USA</td>
                                                    <td class="text-end">240</td>
                                                    <td class="text-end">4.36%</td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <div class="flag">
                                                            <img src="assets/backend/img/flags/au.png" alt="australia" />
                                                        </div>
                                                    </td>
                                                    <td>Australia</td>
                                                    <td class="text-end">119</td>
                                                    <td class="text-end">2.16%</td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <div class="flag">
                                                            <img src="assets/backend/img/flags/ru.png" alt="russia" />
                                                        </div>
                                                    </td>
                                                    <td>Russia</td>
                                                    <td class="text-end">1.081</td>
                                                    <td class="text-end">19.65%</td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <div class="flag">
                                                            <img src="assets/backend/img/flags/cn.png" alt="china" />
                                                        </div>
                                                    </td>
                                                    <td>China</td>
                                                    <td class="text-end">1.100</td>
                                                    <td class="text-end">20%</td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <div class="flag">
                                                            <img src="assets/backend/img/flags/br.png" alt="brazil" />
                                                        </div>
                                                    </td>
                                                    <td>Brasil</td>
                                                    <td class="text-end">640</td>
                                                    <td class="text-end">11.63%</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mapcontainer">
                                            <div id="world-map" class="w-100" style="height: 300px"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <footer class="footer">
            <div class="container-fluid d-flex justify-content-between">
                <nav class="pull-left">
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link" href="http://www.themekita.com">
                                ThemeKita
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"> Help </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"> Licenses </a>
                        </li>
                    </ul>
                </nav>
                <div class="copyright">
                    2024, made with <i class="fa fa-heart heart text-danger"></i> by
                    <a href="http://www.themekita.com">ThemeKita</a>
                </div>
                <div>
                    Distributed by
                    <a target="_blank" href="https://themewagon.com/">ThemeWagon</a>.
                </div>
            </div>
        </footer>
    </div>

    <!-- Custom template | don't include it in your project! -->
    <!-- End Custom template -->
</div>
<!--   Core JS Files   -->
<script src="assets/backend/js/core/jquery-3.7.1.min.js"></script>
<script src="assets/backend/js/core/popper.min.js"></script>
<script src="assets/backend/js/core/bootstrap.min.js"></script>

<!-- jQuery Scrollbar -->
<script src="assets/backend/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>

<!-- Chart JS -->
<script src="assets/backend/js/plugin/chart.js/chart.min.js"></script>

<!-- jQuery Sparkline -->
<script src="assets/backend/js/plugin/jquery.sparkline/jquery.sparkline.min.js"></script>

<!-- Chart Circle -->
<script src="assets/backend/js/plugin/chart-circle/circles.min.js"></script>

<!-- Datatables -->
<script src="assets/backend/js/plugin/datatables/datatables.min.js"></script>

<!-- Bootstrap Notify -->
<script src="assets/backend/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>

<!-- jQuery Vector Maps -->
<script src="assets/backend/js/plugin/jsvectormap/jsvectormap.min.js"></script>
<script src="assets/backend/js/plugin/jsvectormap/world.js"></script>

<!-- Sweet Alert -->
<script src="assets/backend/js/plugin/sweetalert/sweetalert.min.js"></script>

<!-- Kaiadmin JS -->
<script src="assets/backend/js/kaiadmin.min.js"></script>

<!-- Kaiadmin DEMO methods, don't include it in your project! -->
<script src="assets/backend/js/setting-demo.js"></script>
<script src="assets/backend/js/demo.js"></script>
<script>
    $("#lineChart").sparkline([102, 109, 120, 99, 110, 105, 115], {
        type: "line",
        height: "70",
        width: "100%",
        lineWidth: "2",
        lineColor: "#177dff",
        fillColor: "rgba(23, 125, 255, 0.14)",
    });

    $("#lineChart2").sparkline([99, 125, 122, 105, 110, 124, 115], {
        type: "line",
        height: "70",
        width: "100%",
        lineWidth: "2",
        lineColor: "#f3545d",
        fillColor: "rgba(243, 84, 93, .14)",
    });

    $("#lineChart3").sparkline([105, 103, 123, 100, 95, 105, 115], {
        type: "line",
        height: "70",
        width: "100%",
        lineWidth: "2",
        lineColor: "#ffa534",
        fillColor: "rgba(255, 165, 52, .14)",
    });
</script>
<script src="assets/backend/js/slidebar.js"></script>

<script>
    selectSlideBar("dashboard");
</script>
</body>

</html>

