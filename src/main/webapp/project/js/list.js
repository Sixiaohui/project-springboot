function del(id) {
    if(confirm("确定删除吗")){
        $.ajax({
            type: "GET",
            url: "delete?id="+id,
            success: function (data) {
                alert(data.message);
                if(data.success){
                    location.href="list";
                }
            },
            error: function () {
                alert("请求服务器失败，请检查Java控制台报错");
            }
        });
    }
}

function kais(id) {
    if(confirm("确定开始吗")){
        $.ajax({
            type: "GET",
            url: "kais?id="+id,
            success: function (data) {
                alert(data.message);
                if(data.success){
                    location.href="list";
                }
            },
            error: function () {
                alert("请求服务器失败，请检查Java控制台报错");
            }
        });
    }
}

function jies(id) {
    if(confirm("确定结束吗")){
        $.ajax({
            type: "GET",
            url: "jies?id="+id,
            success: function (data) {
                alert(data.message);
                if(data.success){
                    location.href="list";
                }
            },
            error: function () {
                alert("请求服务器失败，请检查Java控制台报错");
            }
        });
    }
}

//提交表单
function gotoPage(index) {
    $("#pageIndex").val(index);
    $("#dataForm").submit();
}


//模态窗口
var modalBox = (function() {
    /*建立模态框对象*/
    var modalBox = {};
    /*获取模态框*/
    modalBox.modal = document.getElementById("myModal");
    /*获得关闭按钮*/
    modalBox.closeBtn = document.getElementById("closeBtn");
    /*模态框显示*/
    modalBox.show = function() {
        console.log(this.modal);
        this.modal.style.display = "block";
    }
    /*模态框关闭*/
    modalBox.close = function() {
        this.modal.style.display = "none";
    }
    /*当用户点击模态框内容之外的区域，模态框也会关闭*/
    modalBox.outsideClick = function() {
        var modal = this.modal;
        window.onclick = function(event) {
            if(event.target == modal) {
                modal.style.display = "none";
            }
        }
    }
    /*模态框初始化*/
    modalBox.init = function() {
        var that = this;
        this.closeBtn.onclick = function() {
            that.close();
        }
        this.outsideClick();
    }
    modalBox.init();
    return modalBox;
})();
//上传excel文件导入数据
$("#submitExcel").click(function () {
    var formData = new FormData();
    formData.append("excel",$("#fileExcel")[0].files[0]);
    $.ajax({
        url : "excel?action=import",
        type : "POST",
        data : formData,
        processData : false,
        contentType : false,
        success : function(res) {
            alert(res.message)
            if(res.success){
                modalBox.close()
                gotoPage(1)
            }
        }
    });
})
