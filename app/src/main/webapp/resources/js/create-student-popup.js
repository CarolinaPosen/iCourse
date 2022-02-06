$(document).ready(function () {

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
                var k = document.getElementById("new-student-authorities");
                if(k != null) k.appendChild(option);
            }
        }
    })

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
                var k = document.getElementById("new-student-roles");
                if(k != null) k.appendChild(option);
            }
        }
    })

    $('.create-student-btn').click(function () {
        var idGroup = $(this).attr('data-id-group');
        $('#createStudentPopup .group').val(idGroup);
        $('#createStudentPopup').modal({
            show:true
        });
    })
})