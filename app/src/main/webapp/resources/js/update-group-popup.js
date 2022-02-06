$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: location.origin + '/trainers',
        dataType: 'json',
        //data: data,
        success: function (responseData) {
            // this prints out your data
            console.log("successful", responseData);

            responseData.responseType = 'json';

            const text = responseData;

            for (var i = 0; i < text.length; i++) {
                var counter = text[i].name;
                console.log("TRAINERS:" + counter);

                const option = document.createElement("option");
                option.text = text[i].name;
                option.value = text[i].id;

                // Append to another element:
                var k = document.getElementById("group-trainers");
                if(k != null) k.appendChild(option);
            }
        }
    })

    $('.change-btn').click(function () {
        var idGroup = $(this).attr('data-id-group');
        var group = $('#group'+idGroup);

        var id = group.find('.id').text();
        $('#updateGroupPopup .id').val(id);

        var name = group.find('.name').text();
        $('#updateGroupPopup .name').val(name);

        $('#updateGroupPopup').modal({
            show:true
        });
    })
})