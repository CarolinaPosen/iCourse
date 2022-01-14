$(document).ready(function () {
    $('.create-student-btn').click(function () {
        var idGroup = $(this).attr('data-id-group');
        $('#createStudentPopup .group').val(idGroup);
        $('#createStudentPopup').modal({
            show:true
        });
    })
})