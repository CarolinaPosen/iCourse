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
                var k = document.getElementById("new-teacher-authorities");
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
                var k = document.getElementById("new-teacher-roles");
                if(k != null) k.appendChild(option);
            }
        }
    })

    $('.create-teacher-btn').click(function () {
        $('#createTeacherPopup').modal({
            show:true
        });
    })
})





