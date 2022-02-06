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
                                var k = document.getElementById("authorities");
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
                                option.class = text[i].name;
                                option.name = text[i].name;
                                option.value = text[i].id;

                                // Append to another element:
                                var k = document.getElementById("roles");
                                if(k != null) k.appendChild(option);
                        }
                }
        })

        $('.change-btn').click(function () {
                var idPerson = $(this).attr('data-id-teacher');
                var teacher = $('#teacher'+idPerson);

                var id = teacher.find('.id').text();
                $('#updateTeacherPopup .id').val(id);

                var name = teacher.find('.name').text();
                $('#updateTeacherPopup .name').val(name);

                var login = teacher.find('.login').text();
                $('#updateTeacherPopup .login').val(login);

                var password = teacher.find('.password').text();
                $('#updateTeacherPopup .password').val(password);

                $('#updateTeacherPopup').modal({
                        show:true
                });
        })
})





