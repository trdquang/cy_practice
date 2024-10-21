<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prime Hotels</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/frontend/css/home.css">
</head>
<body>
<!-- -------------------header -->
<jsp:include page="/WEB-INF/frontend/layout/header.jsp"/>

<!-- --------------------------tìm kiếm ---------------------------------------------------------------------- -->

<div class="background">
    <img src="<%= request.getContextPath() %>/images/background_home.jpg" alt="Hình nền" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; object-fit: cover; z-index: -1;">
    <form class="search-container" action="search_hotel" method="get">
        <input type="text" class="form-control mb-3" name="locationName" placeholder="Địa điểm" style="width: 30%;">

        <div class="form-row mb-3">
            <div class="form-group col-md-6">
                <input type="date" class="form-control" id="startDate" name="startDate" required>
            </div>
            <div class="form-group col-md-6">
                <input type="date" class="form-control" id="endDate" name="endDate" required>
            </div>
        </div>

<%--        <input type="text" class="form-control mb-3" placeholder="Tên khách sạn" style="width: 30%;">--%>

        <button type="submit" class="btn btn-outline-light" style="height: 50%;">
            <i class="fa fa-search"></i>
        </button>
    </form>
</div>

<!-- --------------------------tìm kiếm ---------------------------------------------------------------------- -->


<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
    <div class="row">
        <div class="col-6">
            <h5>Trở thành thành viên</h5>
            <p>Nhận các ưu đãi của chúng tôi</p>
            <button class="btn btn-dark" style="border-radius: 20px;">Tham gia ngay</button>
        </div>
        <div class="col-2"></div>
        <div class="col-4">
<%--            <img src="/images/campus.jpg" alt="Hình ảnh du lịch" class="img-fluid" width="200">--%>
            <img src="<%= request.getContextPath() %>/images/campus.jpg" alt="Hình ảnh du lịch" class="img-fluid" width="200">

        </div>
    </div>
</div>

<hr class="my-4" style=" border: .05px solid black;">


<!-- -------------------Giới thiệu------------------------------------- -->

<div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="width: 50%; margin: 100px auto
">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block w-100" src="/images/background_home.jpeg" width="100%" height="400px" alt="First slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="/images/campus.jpg" width="100%" height="400px" alt="Second slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="/images/hotel.jpg" width="100%" height="400px" alt="Third slide">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<hr class="my-4" style=" border: .05px solid black;">

<!-- fap  -->
<div class="faq" style="margin:100px auto; width: 80%;">
    <h3 class="text-center">Câu hỏi thường gặp</h3>
    <div class="faq-item"
         style="background-color: black; border: .1px solid black; border-radius: 20px; padding: 15px; margin: 10px 0; color: white;">
        <p><strong>Câu hỏi 1:</strong> Nội dung câu hỏi 1?</p>
    </div>
    <div class="faq-item"
         style="background-color: black; border: .1px solid black; border-radius: 20px; padding: 15px; margin: 10px 0; color: white;">
        <p><strong>Câu hỏi 2:</strong> Nội dung câu hỏi 2?</p>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="assets/frontend/js/home.js"></script>
</body>
</html>
