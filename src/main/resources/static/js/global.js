$(function () {
    var login_flag = false;
    var nickname = "";
    $.ajax({
        type: 'POST',
        url: 'api/pTest',
        //从localStorage获取存储的token
        headers : {'Authorization':localStorage["token"]},
        datatype: 'json',
        success: function (data) {
            console.log(data);
            if (data.code === 200){
                login_flag = true;
                $("#nickname").html(data.data.nickName);
                console.log(data.data.nickName);
            }
        }
    })
    if (login_flag){
        $(".news-feed-form").css("display","none");
    }else {
        $("#Notlogged").css("display","none");

    }
})