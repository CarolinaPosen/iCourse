$(document).ready(function () {
        $('.change-btn').click(function () {
                var idPerson = $(this).attr('data-id-teacher');
                var teacher = $('#teacher'+idPerson);

                var id = teacher.find('.id').text();
                $('#updateTeacherPopup .id').val(id);

                var name = teacher.find('.name').text();
                $('#updateTeacherPopup .name').val(name);

                var age = teacher.find('.age').text();
                $('#updateTeacherPopup .age').val(age);

                $('#updateTeacherPopup').modal({
                        show:true
                });
        })
})





