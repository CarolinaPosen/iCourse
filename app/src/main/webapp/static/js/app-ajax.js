// // вызов функции по завершению загрузки страницы
// $(document).ready(function() {
//     $('button').click(function() {
//         $.ajax({
//             url : 'average',     // URL - сервлет
//             data : {                 // передаваемые сервлету данные
//                 userName : $('#userName').val()
//             },
//             success : function(response) {
//                 // обработка ответа от сервера
//                 $('#ajaxUserServletResponse').text(response);
//             }
//         });
//     });
// });



    $('.dog-btn').click(function() {

        var idPerson = $(this).attr('data-id-teacher');
        alert(idPerson)

        var data = JSON.stringify({

            "id": 108,
            "name": "Сафонова Габи Авксентьевна",
            "login": "Noahchie@mail.ru",
            "password": "Asphodel",
            "role": {
            "id": 1,
                "title": "Role"
        },
            "salaries": [
            {
                "id": 6,
                "salary": 409,
                "date": 1608591687451
            },
            {
                "id": 15,
                "salary": 370,
                "date": 1614929519963
            }
            ]

        });
        $.ajax({
            type: "POST",
            url: '/web-app/json2',
            dataType: 'json',
            data: data,
            success: function (responseData) {
                // this prints out your data
                console.log("successful", responseData);
            }
        })
    });





