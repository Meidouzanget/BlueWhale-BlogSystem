//恢复所有属性
function Flush() {
    window.location.reload();
}

function ChangeUserInfo() {
    var phone=$("#cu_phone").val();
    var nickName=$("#cu_nickName").val();
    var sex=$("#cu_sex").val();
    var birth=$("#cu_birth").val();
    var signature=$("#cu_signature").val();
    var userId=$("#cu_userId").val();
    var name=$("#cu_name").val();

    if(phone.length==0)
    {
        alert('手机号码不能为空！');
        return false;
    }
    if(phone.length!=11)
    {
        alert('请输入有效的手机号码，需是11位！');
        return false;
    }

    var myreg = /^(((13[0-9]{1})|( 15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    if(!myreg.test(phone))
    {
        alert('请输入有效的手机号码！');
        return false;
    }

    $.ajax({
        url:"/api/ChangeUserInfo",
        type:"post",
        headers : {'Authorization':localStorage["token"]},
        contentType: 'application/json',
        data: JSON.stringify({
            userId:userId,
            phone:phone,
            nickName:nickName,
            sex:sex,
            birth:birth,
            signature:signature,
            name:name,
        }),
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
            $("#cu_name").attr("value",data.data.name)
            $("#cu_nickName").attr("value",data.data.nickName)
            $("#cu_email").attr("value",data.data.email)
            $("#cu_signature").html(data.data.signature);
            $("#cu_birth").attr("value",data.data.birth)
            $("#cu_sex").attr("value",data.data.sex)
            $("#cu_phone").attr("value",data.data.phone)
            $("#cu_userId").attr("value",data.data.userId)
        }

    })
}