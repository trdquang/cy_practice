function selectSlideBar(str) {

    // Xóa lớp active từ tất cả các nav-item
    const navItems = document.querySelectorAll('.nav-item');
    navItems.forEach(item => {
        item.classList.remove('active');
    });

    // Thêm lớp active vào nav-item tương ứng
    const activeItem = document.getElementById(str);
    if (activeItem) {
        activeItem.classList.add('active');
    }
}
