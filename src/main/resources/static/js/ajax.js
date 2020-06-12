$(function () {



    //图片加载
    $("#imgBut").change(function () {
        var file=$("#imgBut").get(0).files[0];//获取文件对象
        console.log(file);//创建文件读取对象
        var fileReader=new FileReader(); //创建文件读取对象
        fileReader.readAsDataURL(file);//读取文件对象
        fileReader.onload=function (e) {//触发读取事件
            var result=e.target.result;//获取base64加密的图片
            // $("#image").attr("src",result);//设置img的属性来显示图片
            $("#yulan").prop("src",result);//剪切之后进行图片预览
            console.log(result)
        }


    })

    $("#upload").on('click',function () {
        var content=$("#content").val();
        console.log(content)
        var file=$("#imgBut").get(0).files[0];//获取文件对象
        console.log(file);//创建文件读取对象
        fileReader=new FileReader(); //创建文件读取对象
        fileReader.readAsDataURL(file);//读取文件对象
        fileReader.onload=function (e) {//触发读取事件
            var result=e.target.result;//获取base64加密的图片
            // $("#image").attr("src",result);//设置img的属性来显示图片
            $("#yulan").prop("src",result);//剪切之后进行图片预览
            console.log(result)
            $.ajax({
                url: "/article/addArticle",
                type:"post",
                data:{
                    base64Date:result,
                    content:content
                },
                dataType:"json",
                success:function (data) {
                    alert("上传成功！")
                }
            })
        }


    })

})