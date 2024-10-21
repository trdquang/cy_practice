<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<div class="navbar">--%>
<%--    <h5 style="text-align: center;">Quản lý </h5>--%>
<%--    <button style="margin: 0; background-color: #f0f0f0;">Tổng quan</button>--%>
<%--    <button style="margin: 0; background-color: #ddd;">Quản lý khách sạn</button>--%>
<%--    <button style="margin: 0; background-color: #f0f0f0;">Quản lý phòng</button>--%>
<%--    <button style="margin: 0; background-color: #ddd;">Quản lý đơn đặt</button>--%>
<%--    <button style="margin: 0; background-color: #f0f0f0;">Quản lý đánh giá</button>--%>
<%--</div>--%>

<div class="col-2" style="margin-top: 150px; background-color: #f0f0f0;">
    <!-- <div>Admin</div> -->
    <div style="margin-top: 15px;">
        <a  class="btn btn-light btn-block" style="border: none; text-align: left;">Tổng quan</a>
    </div>
    <div style="margin-top: 15px;">
        <a href="http://localhost:8081/booking/admin_hotel" class="btn btn-outline-secondary btn-block" style="border: none; text-align: left">Quản lý khách
            sạn</a>
    </div>
    <div style="margin-top: 15px;">
        <a href="http://localhost:8081/booking/admin_room" class="btn btn-light btn-block" style="border: none; text-align: left">Quản lý phòng</a>
    </div>
    <div style="margin-top: 15px;">
        <a class="btn btn-outline-secondary btn-block" style="border: none; text-align: left">Quản lý
            booking</a>
    </div>
    <div style="margin-top: 15px;">
        <a class="btn btn-light btn-block" style="border: none; text-align: left">Quản lý rating</a>
    </div>
</div>