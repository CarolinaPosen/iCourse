$('.create-mark-btn').click(function () {

    $.ajax({
        type: "GET",
        url: 'http://10.130.30.105:8080/web-app/themes',
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

                $('#createMarkPopup .theme-id' + i).text(text[i].title);
                $('#createMarkPopup .theme-id' + i).val(text[i].id);

            }

            var mark = $('#student-id-main');
            var student = mark.find('.student-id-main').text();
            $('#createMarkPopup .student-id').val(student);

            $('#createMarkPopup').modal({
                show: true
            });

        }

    });
})






