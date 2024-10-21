// Lấy ngày tháng----------------------------------------------
function initializeDateInputs() {
    const today = new Date();
    const dd = String(today.getDate()).padStart(2, '0');
    const mm = String(today.getMonth() + 1).padStart(2, '0'); // Tháng bắt đầu từ 0
    const yyyy = today.getFullYear();
    const formattedDate = `${yyyy}-${mm}-${dd}`;

    // đặt min khi chọn ngày
    document.getElementById('startDate').setAttribute('min', formattedDate);
    document.getElementById('endDate').setAttribute('min', formattedDate);
}

function validateDates() {
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value;

    if (startDate && endDate) {
        const start = new Date(startDate);
        const end = new Date(endDate);

        // ktra end > start 1 ngày
        const diffDays = (end - start) / (1000 * 60 * 60 * 24);
        // if (end <= start || diffDays < 1 || diffDays > 30) {
        //     alert("Ngày kết thúc phải lớn hơn ngày bắt đầu ít nhất 1 ngày và không vượt quá 30 ngày.");
        //     document.getElementById('endDate').value = ''; //xóa end date
        // }

        if (end <= start || diffDays < 1) {
            alert("Ngày kết thúc phải lớn hơn ngày bắt đầu ít nhất 1 ngày ");
            document.getElementById('endDate').value = ''; //xóa end date
        }else if(diffDays > 30){
            alert("Chỉ được đặt tối đa 30 ngày");
            document.getElementById('endDate').value = ''; //xóa end date
        }
    }
}

// gọi khi tải trang
initializeDateInputs();

// lắng nghe sự kiện
document.getElementById('startDate').addEventListener('change', validateDates);
document.getElementById('endDate').addEventListener('change', validateDates);