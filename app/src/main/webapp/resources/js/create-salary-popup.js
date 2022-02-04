$(document).ready(function () {
    $('.create-salary-btn').click(function () {

        var idTrainer = $(this).attr('data-id-teacher');

        var trainer = idTrainer
        $('#createSalaryPopup .trainer').val(trainer);

        $('#createSalaryPopup').modal({
            show:true
        });

    })
})





