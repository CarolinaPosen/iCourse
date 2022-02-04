$(document).ready(function () {
    $('.change-mark-btn').click(function () {

        $.ajax({
            type: "GET",
            url: location.origin + '/themes',
            dataType: 'json',
            //data: data,
            success: function (responseData) {
                // this prints out your data
                console.log("successful", responseData);

                responseData.responseType = 'json';

                const text = responseData;

                for (var i = 0; i < text.length; i++) {
                    var counter = text[i].title;
                    console.log("THEME:" + counter);

                    const option = document.createElement("option");
                    option.text = text[i].title;
                    option.value = text[i].id;

                    // Append to another element:
                    document.getElementById("themes").appendChild(option);
                }
            }
        })



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