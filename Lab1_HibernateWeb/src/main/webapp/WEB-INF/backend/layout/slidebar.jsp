<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/variable.jsp" %>


<!-- Sidebar -->
<div class="sidebar" data-background-color="dark">
    <div class="sidebar-logo">
        <!-- Logo Header -->
        <div class="logo-header" data-background-color="dark">
            <a href="index.html" class="logo">
                <img src="assets/backend/img/kaiadmin/logo_light.svg" alt="navbar brand" class="navbar-brand"
                     height="20"/>
            </a>
            <div class="nav-toggle">
                <button class="btn btn-toggle toggle-sidebar">
                    <i class="gg-menu-right"></i>
                </button>
                <button class="btn btn-toggle sidenav-toggler">
                    <i class="gg-menu-left"></i>
                </button>
            </div>
            <button class="topbar-toggler more">
                <i class="gg-more-vertical-alt"></i>
            </button>
        </div>
        <!-- End Logo Header -->
    </div>

    <%--    -----------------------------------------------------------------------%>
    <div class="sidebar-wrapper scrollbar scrollbar-inner">
        <div class="sidebar-content">
            <ul class="nav nav-secondary">
                <%-------------Dashboard------------------------%>
                <li class="nav-item active" id="dashboard">
                    <a data-bs-toggle="collapse" href="#" class="collapsed" aria-expanded="false"
                       onclick="selectSlideBar('dashboard'); window.location.href='<%= dashboardUrl %>'"; >
                        <i class="fas fa-home"></i>
                        <p>Dashboard</p>
                    </a>

                </li>

                <%-------------Dashboard------------------------%>

                <%-------------form------------------------%>
                <li class="nav-item" id="user">
                    <a data-bs-toggle="collapse" href="javascript:void(0);" class="collapsed" aria-expanded="false"
                       onclick="selectSlideBar('user'); window.location.href='<%= userUrl %>'">
                        <i class="fas fa-user"></i>
                        <p>User</p>
                    </a>
                </li>

                <%-------------form------------------------%>


                <%-------------form------------------------%>
                <li class="nav-item" id="form-2">
                    <a data-bs-toggle="collapse" href="#forms" class="collapsed" aria-expanded="false"
                       onclick="selectSlideBar('form-2')">
                        <i class="fas fa-pen-square"></i>
                        <p>Forms</p>
                    </a>

                </li>
                <%-------------form------------------------%>
            </ul>
        </div>
    </div>
</div>
<!-- End Sidebar -->

<script src="assets/backend/js/slidebar.js"></script>

