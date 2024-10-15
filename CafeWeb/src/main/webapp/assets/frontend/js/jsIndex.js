// var totalPages =0;
var currentPage =0;

function select_option(id) {
    switch (id) {
        case 0:
            break;
        case 1:
            getAllCart();
            let contet_product = `
                <div id="pagination">                   
                </div>
            `;
            // document.getElementById('main_container').innerHTML = contet_product;
            break;
        case 2:
            break;
    }
}

function getAllCart() {
    // let url = "http://localhost:8080/CoffeeRang_war_exploded/ServletGetAllProduct?page="+0;
    // let url = "http://localhost:8081/cafe/cart?currentPage=" + 1;
    let url = `http://localhost:8081/cafe/cart?currentPage=${currentPage}`;

    $.ajax({
        type: "GET",
        dataType: 'json',
        url: url,
        success: function (data) {
            currentPage = data.currentPage;
            totalPages = data.totalPages;
            cartResponeList = data.cartResponeList;
            console.log("current = " + currentPage);
            console.log("totalPages = " + totalPages);
            console.log("data = " + data)
            showPageable(totalPages, currentPage, cartResponeList)
        },
        error: function (error) {
            jsonValue = jQuery.parseJSON(error.responseText);
            alert("error" + error.responseText);
        }
    });
}

function showPageable(totalPages, currentPage, cartResponeList) {

    // -------------------------1. phân trang
    let pagination = `
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
`;
    let item = Number.parseInt(1);
    for (let i = 0; i < totalPages; i++) {
        pagination += `
        <li class="page-item">
            <a class="page-link" href="#" onclick="changePage(${i+1})">${i+1}</a>
        </li>
    `;
    }

    pagination += `
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
    `;

    // console.log(pagination)
    document.getElementById("pagination").innerHTML = pagination;

    // --------------------2. Hiển thị sản phẩm

    let content_product = '';
    // console.log("listData = " + cartResponeList)
    cartResponeList.forEach(cart => {
        content_product += `
            <div class="cart-item text-center">
                <h5 class="cart-item-name">${cart.productName}</h5>
                <span class="cart-item-price text-muted">$${cart.priceEach}</span>
            </div>
        `;
    });
    if (document.getElementById("main_product") != null)
        document.getElementById('main_product').innerHTML = content_product;

}

function changePage(page) {
    // if (page < 0 || page >= totalPage) return;
    currentPage = page; // Cập nhật chỉ số trang hiện tại
    console.log("current is: " + page)
    getAllCart(); // Gọi lại hàm để lấy dữ liệu cho trang mới
}

// function loadMainProduct() {
//     // Thực hiện một yêu cầu AJAX để lấy nội dung sản phẩm
//     $.ajax({
//         url: 'path/to/your/productPage.jsp', // Đường dẫn đến trang JSP của sản phẩm
//         type: 'GET',
//         success: function(data) {
//             document.getElementById('main_product').innerHTML = data; // Cập nhật nội dung cho main_product
//         },
//         error: function(error) {
//             console.error("Error loading products: ", error);
//         }
//     });
// }
