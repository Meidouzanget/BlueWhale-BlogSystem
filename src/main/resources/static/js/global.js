$(function () {
    var login_flag = false;
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
                $("#nickname2").html(data.data.nickName).css("font-size","35px").css("font-weight","bold");
                $("#topAvatar").attr("src",data.data.avatar);
                $("#formImg").attr("src",data.data.avatar);
                $("#avatar").prop("src",data.data.avatar);
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

})