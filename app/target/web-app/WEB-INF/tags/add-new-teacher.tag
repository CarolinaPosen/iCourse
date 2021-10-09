<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<div id="createTeacherPopup" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/web-app/create-teacher" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Create teacher</h4>
                </div>
                <div class="modal-body row">
                    <div class="col-sm-12">
                        <div class="list-group hidden-xs adv-chars">
                            NAME: <input type="text" name="name" class="form-control name"><br>
                            AGE: <input type="number" name="age" class="form-control age"><br>
                            SALARY: <input type="number" name="salary" class="form-control salary"><br>
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

