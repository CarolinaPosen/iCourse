<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<div id="createMarkPopup" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/create-mark" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Create mark</h4>
                </div>
                <div class="modal-body row">
                    <div class="col-sm-12">
                        <div class="list-group hidden-xs adv-chars">
                            MARK:<input type="number" name="mark" class="mark" class="form-control"><br>
                            THEMES:<select id="add_mark_themes" name="themes-id" name="themes" size="8" multiple />
                            StudentID:<input type="number" name="student-id" class="student-id" class="form-control"><br>
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

