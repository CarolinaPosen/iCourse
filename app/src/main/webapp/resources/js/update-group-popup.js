$(document).ready(function () {
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