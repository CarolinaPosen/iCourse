<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<div id="createTeacherPopup" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="${pageContext.request.contextPath}/create-teacher" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Create teacher</h4>
                </div>
                <div class="modal-body row">
                    <div class="col-sm-12">
                        <div class="list-group hidden-xs adv-chars">
                            NAME: <input type="text" name="name" class="form-control name"><br>
                            LOGIN: <input type="text" name="login" class="form-control login"><br>
                            PASSWORD: <input type="text" name="password" class="form-control password"><br>
                            ROLES:
                            <select id="new-teacher-roles" name="new-teacher-role-id" name="roles" size="3" multiple></select><br>

                            AUTHORITIES:
                            <select id="new-teacher-authorities" name="new-teacher-authorities-id" name="authorities" size="3" multiple></select><br>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>

