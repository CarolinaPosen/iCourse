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