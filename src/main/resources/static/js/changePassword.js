$(function () {

})

function updataPassword() {
    var oPassword=$("#oPassword").val();
    var nPassword1=$("#nPassword1").val();
    var nPassword2=$("#nPassword2").val();



    if (nPassword1==nPassword2){
        $.ajax({
            url:"/api/ChangePassword",
            type:"post",
            headers : {'Authorization':localStorage["token"]},
            data:{
                oPassword:oPassword,
                nPassword:nPassword1,

            },
            success:function () {
                 window.location.reload();
                alert("修改成功");
            }
        })
    }else {
        alert("两次密码输入不相等")
    }


}