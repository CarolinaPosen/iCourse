<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<div id="updateMarkPopup" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="${pageContext.request.contextPath}/mark-edit" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Send changes</h4>
                </div>
                <div class="modal-body row">
                    <div class="col-sm-12">
                        <div class="list-group hidden-xs adv-chars">
                            ID:<input type="number" name="id" class="id" class="form-control"><br>
                            MARK:<input type="number" name="mark" class="mark" class="form-control"><br>
                            DATE:<input type="date" name="date" class="date" class="form-control"><br>
                            THEME:<input type="number" name="theme-id" class="theme-id" class="form-control"><br>
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