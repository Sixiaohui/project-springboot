$(document).ready(function() {
    var options = {
        beforeSubmit:  showRequest,  // pre-submit callback
        success:       showResponse  // post-submit callback
    };
    $('#editForm').ajaxForm(options).submit(function(){return false;});
});
function showRequest() {
    //提交之前校验处
    return true;
}
function showResponse(data) {
    alert(data.message);
    if (data.success) {
        window.location.href = "list";
    }
}
function delFile(me) {
    $(me).prev().val('')
    $(me).parent().css('display', 'none');
}
