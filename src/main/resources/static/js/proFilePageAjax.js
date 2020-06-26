$(function () {
    var result = "";
    //图片预览
    $("#headPortrait").change(function () {
        var file = $("#headPortrait").get(0).files[0];//获取文件对象
        console.log(file);//创建文件读取对象
        var fileReader = new FileReader(); //创建文件读取对象
        fileReader.readAsDataURL(file);//读取文件对象
        fileReader.onload = function (e) {//触发读取事件
            result = e.target.result;//获取base64加密的图片
            // $("#image").attr("src",result);//设置img的属性来显示图片
            $("#yulan").prop("src", result);//剪切之后进行图片预览
            console.log(result)
        }


    })

    $.ajax({
        type: 'POST',
        url: 'api/pTest',
        //从localStorage获取存储的token
        headers : {'Authorization':localStorage["token"]},
        datatype: 'json',
        success: function (data) {
            console.log(data);
            var userId = data.data.userId;

            $.ajax({
                url: "/api/updateByIduUrl",
                type: "post",
                data: {

                    userId: userId,
                    base64Date: result
                },
                dataType: "json",
                success: function () {

                }
            })
        }
    })
})




