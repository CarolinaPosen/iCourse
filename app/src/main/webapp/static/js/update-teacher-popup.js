$(document).ready(function () {
        $('.change-btn').click(function () {
                var idPerson = $(this).attr('data-id-teacher');
                var teacher = $('#teacher'+idPerson);

                var id = teacher.find('.id').text();
                $('#updateTeacherPopup .id').val(id);

                var name = teacher.find('.name').text();
                $('#updateTeacherPopup .name').val(name);

                var login = teacher.find('.login').text();
                $('#updateTeacherPopup .login').val(login);

                var password = teacher.find('.password').text();
                $('#updateTeacherPopup .password').val(password);

                $('#updateTeacherPopup').modal({
                        show:true
                });
        })
})





