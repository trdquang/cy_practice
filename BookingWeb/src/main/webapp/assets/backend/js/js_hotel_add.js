console.log("----------------welcome to js-----------------------")

function onChangeSelectLocation(level, id_parent) {
    searchLocation(level, id_parent);
}

function searchLocation(level, idParent) {
    let url = `http://localhost:8081/booking/location_gson?level=${level}&id_parent=${idParent}`;

    $.ajax({
        type: "GET",
        dataType: 'json',
        url: url,
        success: function (data) {

            if (Array.isArray(data)) {
                // console.log("data is an array");

                // Xóa các tùy chọn cũ trong select huyện
                if(level == 2) {
                    $("#district").empty();
                    $("#district").append('<option value="0">Chọn huyện</option>'); // Thêm tùy chọn mặc định


                    $("#commune").empty();
                    $("#commune").append('<option value="0">Chọn xã</option>');

                    // Duyệt qua từng phần tử trong mảng và thêm vào select
                    data.forEach(function (item) {
                        // Giả sử mỗi item có thuộc tính id và name
                        $("#district").append('<option value="' + item.id + '">' + item.name + '</option>');
                    });
                }else if(level == 3){
                    $("#commune").empty();
                    $("#commune").append('<option value="0">Chọn xã</option>'); // Thêm tùy chọn mặc định

                    // Duyệt qua từng phần tử trong mảng và thêm vào select
                    data.forEach(function (item) {
                        // Giả sử mỗi item có thuộc tính id và name
                        $("#commune").append('<option value="' + item.id + '">' + item.name + '</option>');
                    });
                }
            } else {
                console.log("data is not an array");
            }

        },
        error: function (error) {
            jsonValue = jQuery.parseJSON(error.responseText);
            alert("error" + error.responseText);
        }
    });
}