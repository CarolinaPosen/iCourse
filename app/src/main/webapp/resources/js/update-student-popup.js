$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: location.origin + '/roles',
        dataType: 'json',
        //data: data,
        success: function (responseData) {
            // this prints out your data
            console.log("successful", responseData);

            responseData.responseType = 'json';

            const text = responseData;

            for (var i = 0; i < text.length; i++) {
                var counter = text[i].name;
                console.log("ROLES:" + counter);

                const option = document.createElement("option");
                option.text = text[i].name;
                option.value = text[i].id;

                // Append to another element:
                document.getElementById("student-roles").appendChild(option);
            }
        }
    })

    $.ajax({
        type: "GET",
        url: location.origin + '/authorities',
        dataType: 'json',
        //data: data,
        success: function (responseData) {
            // this prints out your data
            console.log("successful", responseData);

            responseData.responseType = 'json';

            const text = responseData;

            for (var i = 0; i < text.length; i++) {
                var counter = text[i].name;
                console.log("AUTHORITIES:" + counter);

                const option = document.createElement("option");
                option.text = text[i].name;
                option.value = text[i].id;

                // Append to another element:
                document.getElementById("student-authorities").appendChild(option);
            }
        }
    })


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