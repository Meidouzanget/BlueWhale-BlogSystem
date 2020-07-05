//登出
function logout() {
    localStorage["token"]="";
    window.location.href="/Login";
    alert("登出");
}

$(function () {
    var login_flag = false;
    var avataruname=$("#p-username").html();
    $.ajax({
        type: 'POST',
        url: '/api/pTest',
        //从localStorage获取存储的token
        headers : {'Authorization':localStorage["token"]},
        datatype: 'json',
        success: function (data) {
            console.log(data);
            if (data.code === 200){
                login_flag = true;
                $("#nickname").html(data.data.nickName).css("font-size","20px");
                $("#topAvatar").attr("src",data.data.avatar);
                $("#formImg").attr("src",data.data.avatar);
                $("#username").html("@"+data.data.name).css("font-size","10px");
                $(".user").attr("href","/u/"+data.data.name);
                console.log(data.data.nickName);
                console.log(login_flag)
                    $("#addform").css("display","block");
                    $("#Notlogged").css("display","none");
                    $(".profile-page").prop("href","/u/"+data.data.name);
                    $("#control-center").css("display","flex");
                    $(".is-empty").removeClass("is-empty");
            }
        }
    })
    $.ajax({
        type: 'POST',
        url: '/api/QueryAvatar',
        data:{ username:avataruname },
        datatype: 'json',
        success: function (data) {
            console.log(data);
            if (data.code === 200){
                $("#nickname2").html(data.data.name).css("font-size","35px").css("font-weight","bold");
                $("#avatar").prop("src",data.data.avatar);

            }
        }
    })

})