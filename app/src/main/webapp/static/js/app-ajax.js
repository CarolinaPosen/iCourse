// вызов функции по завершению загрузки страницы
$(document).ready(function() {
    $('button').click(function() {
        $.ajax({
            url : 'average',     // URL - сервлет
            data : {                 // передаваемые сервлету данные
                userName : $('#userName').val()
            },
            success : function(response) {
                // обработка ответа от сервера
                $('#ajaxUserServletResponse').text(response);
            }
        });
    });
});

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
