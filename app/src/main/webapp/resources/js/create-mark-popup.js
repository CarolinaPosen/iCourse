$('.create-mark-btn').click(function () {

    $.ajax({
        type: "GET",
        url: location.origin + '/themes',
        dataType: 'json',
        //data: data,
        success: function (responseData) {
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
                document.getElementById("add_mark_themes").appendChild(option);
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






