$(document).ready(function () {
    $('.change-salary-btn').click(function () {

        var idSalary = $(this).attr('data-id-salary');
        var salary = $('#salary'+idSalary);

        var id = salary.find('.id').text();
        $('#updateSalaryPopup .id').val(id);

        var number = salary.find('.salary').text();
        $('#updateSalaryPopup .salary').val(number);

        var date = salary.find('.date').text();
        $('#updateSalaryPopup .date').val(date);

        var trainer = salary.find('.trainer').text();
        $('#updateSalaryPopup .trainer').val(trainer);

        $('#updateSalaryPopup').modal({
            show:true
        });
    })
})