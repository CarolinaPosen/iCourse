// $(document).ready(function () {
//     $('.change-salary-btn').click(function () {
//         //var trainer = $('#data-id-trainer').val();
//
//         var idPerson = $(this).attr('data-id-trainer');
//         var teacher = $('#teacher');
//
//         var id = teacher.find('.id').text();
//
//         alert("1MESSAGE!!"+id);
//
//     })
// })

/*function submitForm(thisObj, thisEvent) {
    var name = $('#name').val();
    var password = $('#password').val();

    var myData = {
        "mydata": {
            "name": name,
            "password": password
        }
    };
    $.ajax({
        type: "POST",
        url: "/Aasd",
        data: {
            jsonData: JSON.stringify(myData)
        },
        dataType: "json"
    });
    return false;
}*/


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

/*
var data = JSON.stringify({name: 'dog'});
$.ajax({
    type: "POST",
    url: 'http://localhost:8084/MyApp/JavaScriptInterface',
    dataType: 'json',
    data: data,
    success: function (responseData) {
        // this prints out your data
        console.log("successful", responseData);
    }
})*/
