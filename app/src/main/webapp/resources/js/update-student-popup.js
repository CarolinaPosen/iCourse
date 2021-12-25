$(document).ready(function () {
    $('.change-btn').click(function () {
        var idPerson = $(this).attr('data-id-student');
        var student = $('#student'+idPerson);
        var url = $(this).attr('url');

        var id = student.find('.id').text();
        $('#updateStudentPopup .id').val(id);

        var name = student.find('.name').text();
        $('#updateStudentPopup .name').val(name);

        var login = student.find('.login').text();
        $('#updateStudentPopup .login').val(login);

        var password = student.find('.password').text();
        $('#updateStudentPopup .password').val(password);

        $('#updateStudentPopup').modal({
            show:true
        });
    })
})