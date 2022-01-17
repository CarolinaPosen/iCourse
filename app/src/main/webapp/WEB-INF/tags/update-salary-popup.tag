<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<div id="updateSalaryPopup" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="${pageContext.request.contextPath}/salary-edit" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Send changes</h4>
                </div>
                <div class="modal-body row">
                    <div class="col-sm-12">
                        <div class="list-group hidden-xs adv-chars">
                            ID:<input type="number" name="id" class="id" class="form-control"><br>
                            SALARY:<input type="number" name="salary" class="salary" class="form-control"><br>
                            DATE:<input type="date" name="date" class="date" class="form-control"><br>
                            TrainerID:<input type="number" name="trainer" class="trainer" class="form-control"><br>
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