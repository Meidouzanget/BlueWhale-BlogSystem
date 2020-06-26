$(function () {

})

function updataPassword() {
    var password=$("#password").val();
    var newPassword1=$("#newPassword1").val();
    var newPassword2=$("#newPassword2").val();

    if (newPassword1==newPassword2){
        $.ajax({
            url:"",
            type:"post",
            headers : {'Authorization':localStorage["token"]},
            data:{
                password:password,
                newPassword1:newPassword1,
                newPassword2:newPassword2
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