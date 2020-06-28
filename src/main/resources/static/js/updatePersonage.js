function ChangeUserInfo() {
    var phone=$("#phone").val();
    var nickName=$("#nickName").val();
    var sex=$("#sex").val();
    var birth=$("#birth").val();
    var signature=$("#signature").val();
    var email=$("#email").val();

    $.ajax({
        url:"/api/ChangeUserInfo",
        type:"post",
        headers : {'Authorization':localStorage["token"]},
        data:{
            phone:phone,
            nickName:nickName,
            sex:sex,
            birth:birth,
            signature:signature,
            email:email,
        },
        datetype:"json",
        success:function () {
            alert("修改成功")
            window.location.reload();

        }
    })
}


$(function () {
    QueryUserInfo();

})
function QueryUserInfo() {

    $.ajax({
        url:"/api/QueryUserInfo",
        type:"post",
        headers : {'Authorization':localStorage["token"]},
        success:function (data) {
            $("#name").attr("value",data.data.name)
            $("#nickName").attr("value",data.data.nickName)
            $("#email").attr("value",data.data.email)
            $("#signature").attr("value",data.data.signature)
            $("#birth").attr("value",data.data.birth)
            $("#sex").attr("value",data.data.sex)
        }

    })
}