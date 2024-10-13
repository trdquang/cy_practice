<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add to Cart</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
    <style>
        .product-card {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s; /* Hiệu ứng chuyển đổi */
        }
        .product-card:hover {
            transform: scale(1.05); /* Phóng to khi hover */
        }
        .product-card img {
            max-width: 100%;
            height: auto;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/frontend/layout/header.jsp" />
<div class="container">
    <h1 class="text-center mt-4">Thêm vào Giỏ Hàng</h1>
    <div class="row mt-4">
        <div class="col-md-5">
            <div class="product-card text-center">
                <img src="<%= request.getContextPath() %>/images/product.png" alt="Product Image" class="img-fluid mb-3" />
                <h5 class="mt-2 font-weight-bold">${product.productName}</h5>
                <p class="text-muted">Line: ${product.productLine}</p>
                <p class="font-weight-bold">Quantity: ${product.quantityInStock}</p>
                <p class="text-success font-weight-bold">Price: $${product.buyPrice}</p>
            </div>
        </div>
<%--        <div class="col-md-1">--%>
        <div class="col-md-4 d-flex align-items-center ml-3">
            <form id="purchaseForm" action="addOrder" method="post" class="w-100">
                <div class="form-group">
                    <label for="quantity">Số lượng:</label>
                    <input type="number" name="quantity" id="quantity" class="form-control"  >
                    <input type="hidden" name="price" id="price" value="${product.buyPrice}"  >
                    <input type="hidden" name="idProduct" id="idProduct" value="${product.productCode}"  >

                </div>
                <button type="button" class="btn btn-primary mt-3" onclick="confirmPurchase()">Mua hàng</button>
            </form>
        </div>

    </div>
</div>

<script>
    function confirmPurchase() {
        var quantity = document.getElementById('quantity').value;
        if (quantity <= 0  || quantity > ${product.quantityInStock}) {
            swal("Số lượng không hợp lệ");
            return;
        }
        swal({
            title: "Xác nhận mua hàng",
            text: "Bạn có chắc chắn muốn mua " + quantity + " sản phẩm?",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Có, mua hàng!",
            cancelButtonText: "Không, hủy bỏ!",
            closeOnConfirm: false
        }, function(isConfirm) {
            if (isConfirm) {
                document.getElementById('purchaseForm').submit();
            }
        });
    }
</script>
</body>
</html>
