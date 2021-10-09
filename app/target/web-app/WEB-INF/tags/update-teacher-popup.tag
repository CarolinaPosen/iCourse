<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<div id="updateTeacherPopup" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/web-app/teacher-edit" method="post">
            <div class="modal-header">
                <h4 class="modal-title">Send changes</h4>
            </div>
            <div class="modal-body row">
                <div class="col-sm-12">
                    <div class="list-group hidden-xs adv-chars">
                            <input type="number" class="id" name="id" class="form-control"><br>
                            <input type="text" name="name" class="form-control name"><br>
                            <input type="number" name="age" class="form-control age"><br>
                            <input type="number" name="salary" class="form-control salary"><br>
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

