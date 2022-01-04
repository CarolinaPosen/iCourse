<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<div id="createMarkPopup" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/web-app/create-mark" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Create mark</h4>
                </div>
                <div class="modal-body row">
                    <div class="col-sm-12">
                        <div class="list-group hidden-xs adv-chars">
                            MARK:<input type="number" name="mark" class="mark" class="form-control"><br>

                            <select name="themes-id" name="themes" size="8" multiple>
                                <option type="text" class="theme-id0"></option>
                                <option type="text" class="theme-id1"></option>
                                <option type="text" class="theme-id2"></option>
                                <option type="text" class="theme-id3"></option>
                                <option type="text" class="theme-id4"></option>
                                <option type="text" class="theme-id5"></option>
                                <option type="text" class="theme-id6"></option>
                                <option type="text" class="theme-id7"></option>
                                <option type="text" class="theme-id8"></option>
                            </select>

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

