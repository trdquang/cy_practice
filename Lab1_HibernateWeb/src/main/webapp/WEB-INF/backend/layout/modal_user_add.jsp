<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade" id="addRowModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
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
            <div class="modal-body">
                <p class="small">
                    Create a new row using this form, make sure you
                    fill them all
                </p>

                <%-----------------------------------form start--%>
                <form>
                    <div class="row">
                        <div class="col-sm-12">
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
                        <div class="col-md-6">
                            <div class="form-group form-group-default">
                                <label>Office</label>
                                <input id="addOffice" type="text" class="form-control" placeholder="fill office"/>
                            </div>
                        </div>
                    </div>
                </form>

                <%-----------------------------------form end--%>
            </div>
            <div class="modal-footer border-0">
                <button type="button" class="btn btn-primary" >Add</button>
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>