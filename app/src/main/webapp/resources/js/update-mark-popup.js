$(document).ready(function () {
    $('.change-mark-btn').click(function () {

        var idMark = $(this).attr('data-id-mark');
        var mark = $('#mark'+idMark);

        var id = mark.find('.id').text();
        $('#updateMarkPopup .id').val(id);

        var grade = mark.find('.mark').text();
        $('#updateMarkPopup .mark').val(grade);

        var date = mark.find('.date').text();
        $('#updateMarkPopup .date').val(date);

        var theme = mark.find('.theme-id').text();
        $('#updateMarkPopup .theme-id').val(theme);

        var student = mark.find('.student-id').text();
        $('#updateMarkPopup .student-id').val(student);

        $('#updateMarkPopup').modal({
            show:true
        });
    })
})