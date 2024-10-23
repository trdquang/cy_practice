<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .modal {
        z-index: 1051; /* Đảm bảo modal có z-index cao hơn SweetAlert */
    }
</style>

<div class="modal fade" id="addRowModal" tabindex="-1" role="dialog" aria-hidden="true" data-bs-backdrop="static">
    <div class="modal-dialog modal-dialog-centered " role="document" style="max-width: 80%;">
        <div class="modal-content">
            <div class="modal-header border-0">
                <h5 class="modal-title">
                    <span class="fw-mediumbold"> New</span>
                    <span class="fw-light"> Row </span>
                </h5>
                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" style="">
                <%--                <p class="small">--%>
                <%--                    Create a new row using this form, make sure you--%>
                <%--                    fill them all--%>
                <%--                </p>--%>

                <%-----------------------------------form start--%>
                <form id="formAdd">
                    <div class="row">
                        <%--                        <div class="col-sm-12">--%>
                        <div class="col-xl-12">
                            <div class="form-group form-group-default">
                                <label>Name</label>
                                <input id="addName" type="text" class="form-control" placeholder="fill name"/>
                            </div>
                        </div>
                        <div class="col-md-6 pe-0">
                            <div class="form-group form-group-default">
                                <label>Position</label>
                                <input id="addPosition" type="text" class="form-control" placeholder="fill position"/>
                            </div>
                        </div>

                        <!-- tmp -->

                        <div class="col-md-6">
                            <div class="form-group form-group-default">
                                <label>Office</label>
                                <input id="addOffice" type="text" class="form-control" placeholder="fill office"/>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-group form-group-default">
                                <label>Office</label>
                                <input id="addOffice" type="text" class="form-control" placeholder="fill office"/>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-group form-group-default">
                                <label>Office</label>
                                <input id="addOffice" type="text" class="form-control" placeholder="fill office"/>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-group form-group-default">
                                <label>Office</label>
                                <input id="addOffice" type="text" class="form-control" placeholder="fill office"/>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-group form-group-default">
                                <label>Office</label>
                                <input id="addOffice" type="text" class="form-control" placeholder="fill office"/>
                            </div>
                        </div>

                        <!-- tmp -->


                    </div>
                </form>

                <%-----------------------------------form end--%>
            </div>
            <div class="modal-footer border-0">
                <button type="button" class="btn btn-primary" id="addRowButton">Add</button>
<%--                <button type="button" class="btn btn-primary" id="addRowButton">Test</button>--%>
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script src="assets/backend/js/core/jquery-3.7.1.min.js"></script>
<script src="assets/backend/js/plugin/sweetalert/sweetalert.min.js"></script>


<script>
    $("#addRowButton").click(function (e) {
        swal({
            title: "Thêm sản phẩm?",
            text: "Bạn có muốn thêm sản phẩm",
            type: "warning",
            buttons: {
                cancel: {
                    visible: true,
                    text: "Quay lại",
                    className: "btn btn-danger",
                },
                confirm: {
                    text: "Đồng ý",
                    className: "btn btn-success",
                },
            },
        }).then((willSave) => {
            if (willSave) {

                swal("Thêm sản phẩm", {
                    icon: "success",
                    buttons: {
                        confirm: {
                            className: "btn btn-success",
                        },
                    },
                }).then(() => {
                    // Gửi form
                    document.getElementById("formAdd").submit();
                });
            }
        });
    });

</script>
