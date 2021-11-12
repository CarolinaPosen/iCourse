<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>



<div id="updateTeacherPopup" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="${pageContext.request.contextPath}/teacher-edit" method="post">
            <div class="modal-header">
                <h4 class="modal-title">Send changes</h4>
            </div>
            <div class="modal-body row">
                <div class="col-sm-12">
                    <div class="list-group hidden-xs adv-chars">
                        ID:<input type="number" name="id" class="id" name="id" class="form-control"><br>
                        NAME:<input type="text" name="name" class="name" class="form-control"><br>
                        LOGIN:<input type="text" name="login" class="login" class="form-control"><br>
                        PASSWORD:<input type="text" name="password" class="password" class="form-control"><br>
                        ROLE:<p><select name="role" size="3" multiple>
                        <option selected type="number" value="1"> Administrator</option>
                        <option type="number" value="2"> Manager</option>
                        <option type="number" value="3"> User</option>
                    </select><br>
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

