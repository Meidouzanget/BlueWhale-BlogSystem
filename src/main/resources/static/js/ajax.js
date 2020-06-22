function packup(answerId){
    var comments="comments"+answerId;
    console.log(comments)
    $("#"+comments+"").empty();;
}

function getToken(){
    $.ajax({
        type: 'POST',
        url: 'api/pTest',
        //从localStorage获取存储的token
        headers : {'Authorization':localStorage["token"]},
        datatype: 'json',
        success: function (data) {
            console.log(data);
        }
    })
}

//发表评论
function addcomment(answerId) {
    var userId=1;
    var comments="comments"+answerId;
    var commentContent=$("#commentContent").val();
    //发表评论
    $.ajax({
        url: "/api/addComment",
        type: "post",
        data: {
            answerId: answerId,
            userId:userId,
            content: commentContent

        },
        dataType: "json",
        success:function () {
            //查询最新一条评论
            $.ajax({
                url: "/api/userComment",
                type: "get",
                data: {
                    answerId: answerId,
                },
                dataType: "json",
                success:function (data) {
                    $("#"+comments+"").prepend("\t\t\t\t\t<ul class=\"comments-list\" >\n" +
                        "\t\t\t\t\t\t<li class=\"comment-item\">\n" +
                        "\t\t\t\t\t\t\t<div class=\"post__author author vcard inline-items\">\n" +
                        "\t\t\t\t\t\t\t\t<img src=\"img/author-page.jpg\" alt=\"author\">\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"author-date\">\n" +
                        "\t\t\t\t\t\t\t\t\t<a class=\"h6 post__author-name fn\" href=\"02-ProfilePage.html\">"+data[0].nickName+"</a>\n" +
                        "\t\t\t\t\t\t\t\t\t<div class=\"post__date\">\n" +
                        "\t\t\t\t\t\t\t\t<time class=\"published\"  >\n" + data[0].createTime +
                        "\n" +
                        "\t\t\t\t\t\t\t\t\t\t</time>\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t\t<a href=\"#\" class=\"more\"><svg class=\"olymp-three-dots-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-three-dots-icon\"></use></svg></a>\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t<p>"+data[0].content+"</p>\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t<a href=\"#\" class=\"post-add-icon inline-items\">\n" +
                        "\t\t\t\t\t\t\t\t<svg class=\"olymp-heart-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-heart-icon\"></use></svg>\n" +
                        "\t\t\t\t\t\t\t\t<span></span>\n" +
                        "\t\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t\t\t<a href=\"#\" class=\"reply\">删除评论</a>\n" +
                        "\t\t\t\t\t\t</li>")
                },error:function (e) {
                    console.log("查看评论错误"+e)
                }
            })
        },error:function () {
            console.log("评论失败")
        }
    })
    $("input[type=reset]").trigger("click");//触发reset

}



//查看评论
function comments(answerId) {
        var uId=1;
        var comments="comments"+answerId;
        console.log(comments)

        $.ajax({
            url: "/api/selectAllComment",
            type: "get",
            data: {
                answerId: answerId
            },
            dataType: "json",
            success:function (data) {
                console.log(data);
                console.log(answerId);
                $("#"+comments+"").empty();
                $.each(data, function (index, item) {
                    $("#"+comments+"").append("\t\t\t\t\t<ul class=\"comments-list\" >\n" +
                        "\t\t\t\t\t\t<li class=\"comment-item\">\n" +
                        "\t\t\t\t\t\t\t<div class=\"post__author author vcard inline-items\">\n" +
                        "\t\t\t\t\t\t\t\t<img src=\"img/author-page.jpg\" alt=\"author\">\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"author-date\">\n" +
                        "\t\t\t\t\t\t\t\t\t<a class=\"h6 post__author-name fn\" href=\"02-ProfilePage.html\">"+item.nickName+"</a>\n" +
                        "\t\t\t\t\t\t\t\t\t<div class=\"post__date\">\n" +
                        "\t\t\t\t\t\t\t\t<time class=\"published\" datetime=\"2004-07-24T18:18\" >\n" + item.createTime +
                        "\n" +
                        "\t\t\t\t\t\t\t\t\t\t</time>\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t\t<a href=\"#\" class=\"more\"><svg class=\"olymp-three-dots-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-three-dots-icon\"></use></svg></a>\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t<p>"+item.content+"</p>\n" +
                        "\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t<a href=\"#\" class=\"post-add-icon inline-items\">\n" +
                        "\t\t\t\t\t\t\t\t<svg class=\"olymp-heart-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-heart-icon\"></use></svg>\n" +
                        "\t\t\t\t\t\t\t\t<span></span>\n" +
                        "\t\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t\t\t<a href=\"#\" class=\"reply\">删除评论</a>\n" +
                        "\t\t\t\t\t\t</li>")

                })
                $("#"+comments+"").append("<form class=\"comment-form inline-items\" >\n" +
                    "\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t<div class=\"post__author author vcard inline-items\">\n" +
                    "\t\t\t\t\t\t\t<img src=\"img/author-page.jpg\" alt=\"author\">\n" +
                    "\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t\t<div class=\"form-group with-icon-right \">\n" +
                    "\t\t\t\t\t\t\t\t<textarea class=\"form-control\" placeholder=\"\" id='commentContent'></textarea>\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"add-options-message\">\n" +
                    "\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"options-message\" data-toggle=\"modal\" data-target=\"#update-header-photo\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t<svg class=\"olymp-camera-icon\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t<use xlink:href=\"svg-icons/sprites/icons.svg#olymp-camera-icon\"></use>\n" +
                    "\t\t\t\t\t\t\t\t\t\t</svg>\n" +
                    "\t\t\t\t\t\t\t\t\t</a>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t<button class=\"btn btn-md-2 btn-primary\" onclick='addcomment("+answerId+")' type='button'>发布评论</button>\n" +
                    "\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t<button class=\"btn btn-md-2 btn-border-think c-grey btn-transparent custom-color\" onclick='packup("+answerId+")' type='button'>收起</button>\n" +
                    "\t\t\t\t\t\t<input type=\"reset\" style=\"display:none;\" />\n" +
                    "\t\t\t\t\t\n" +
                    "\t\t\t\t\t</form>");



            },
            error:function (e) {
                console.log("查看评论错误"+e)
            }

        })



}


var greatflag=false;

//点赞
function Great(greatId) {
    var userId=1;
    var aId=greatId;
    var gid = "#Great"+greatId;
    if (!greatflag){
        let val = $(gid).html();
        let sum =0;
        sum=parseInt(val)+1;
        $(gid).text(sum);
        greatflag=true;
    }else {
        let val = $(gid).html();
        let sum =0;
        sum=parseInt(val)-1;
        $(gid).text(sum);
        greatflag=false;
    }



    console.log("gid"+gid)
    console.log("aId:"+aId);
    $.ajax({
        url: "/api/great",
        type: "post",
        data: {
            uId: userId,
            aId: aId
        },
        success: function (e) {

        },error:function (e) {
            console.log(e)
        }

    })
}

$(function () {
    select();
    getToken();
    var result = "";
    var userId=1;
    //图片预览
    $("#imgBut").change(function () {
        var file = $("#imgBut").get(0).files[0];//获取文件对象
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

    //发帖
    $("#upload").on('click', function () {
        var content = $("#content").val();
        console.log(content);
        var file = $("#imgBut").get(0).files[0];//获取文件对象
        if (file!=null){
            fileReader = new FileReader(); //创建文件读取对象
            fileReader.readAsDataURL(file);//读取文件对象
            fileReader.onload = function (e) {    //触发读取事件
                result = e.target.result;//获取base64加密的图片
                // $("#image").attr("src",result);//设置img的属性来显示图片
                $("#yulan").prop("src", result);//剪切之后进行图片预览
                // console.log(result)

            }
        }
            if(content==null || file==null){
                alert("内容或图片不能为空！！！")
            }else {
                $.ajax({
                    url: "/api/addArticle",
                    type: "post",
                    data: {
                        base64Date: result,
                        content: content,
                        userId: userId
                    },
                    dataType: "json",
                    success: function () {
                        //查询最新一条文章
                        $.ajax({
                            url: "/article/articleUser",
                            type: "get",
                            dataType: "json",
                            success:function (data) {
                                $("#d3").prepend("\t<div class=\"ui-block\">\n" +
                                    "\n" +
                                    "\n" +
                                    "\t\t\t\t<article class=\"hentry post\">\n" +
                                    "\n" +
                                    "\t\t\t\t\t<div class=\"post__author author vcard inline-items\">\n" +
                                    "\t\t\t\t\t\t<img src=\"/img/avatar10-sm.jpg\" alt=\"author\">\n" +
                                    "\n" +
                                    "\t\t\t\t\t\t<div class=\"author-date\">\n" +
                                    "\t\t\t\t\t\t\t<a class=\"h6 post__author-name fn\" href=\"#\">"+data[0].nickName+"</a>\n" +
                                    "\t\t\t\t\t\t\t<div class=\"post__date\">\n" +
                                    "\t\t\t\t\t\t\t\t<time class=\"published\" datetime=\"2004-07-24T18:18\" >\n" + data[0].createTime +
                                    "\n" +
                                    "\t\t\t\t\t\t\t\t</time>\n" +
                                    "\t\t\t\t\t\t\t</div>\n" +
                                    "\t\t\t\t\t\t</div>\n" +
                                    "\n" +
                                    "\t\t\t\t\t\t<div class=\"more\"><svg class=\"olymp-three-dots-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-three-dots-icon\"></use></svg>\n" +
                                    "\t\t\t\t\t\t\t<ul class=\"more-dropdown\">\n" +
                                    "\t\t\t\t\t\t\t\t<li>\n" +
                                    "\t\t\t\t\t\t\t\t\t<a href=\"#\">Edit Post</a>\n" +
                                    "\t\t\t\t\t\t\t\t</li>\n" +
                                    "\t\t\t\t\t\t\t\t<li>\n" +
                                    "\t\t\t\t\t\t\t\t\t<a href=\"#\">Delete Post</a>\n" +
                                    "\t\t\t\t\t\t\t\t</li>\n" +
                                    "\t\t\t\t\t\t\t\t<li>\n" +
                                    "\t\t\t\t\t\t\t\t\t<a href=\"#\">Turn Off Notifications</a>\n" +
                                    "\t\t\t\t\t\t\t\t</li>\n" +
                                    "\t\t\t\t\t\t\t\t<li>\n" +
                                    "\t\t\t\t\t\t\t\t\t<a href=\"#\">Select as Featured</a>\n" +
                                    "\t\t\t\t\t\t\t\t</li>\n" +
                                    "\t\t\t\t\t\t\t</ul>\n" +
                                    "\t\t\t\t\t\t</div>\n" +
                                    "\n" +
                                    "\t\t\t\t\t</div>\n" +
                                    "\n" +
                                    "\t\t\t\t\t<p>\n" + data[0].content +
                                    "\t\t\t\t\t</p>\n" +
                                    "\n" +
                                    "\t\t\t\t\t<div class=\"post-thumb\">\n" +
                                    "\t\t\t\t\t\t<img src=\"" + data[0].url + "\" alt=''>\n" +
                                    "\t\t\t\t\t</div>\n" +
                                    "\n" +
                                    "\t\t\t\t\t<div class=\"post-additional-info inline-items\" >\n" +
                                    "\n" +
                                    "\t\t\t\t\t\t<a class=\"post-add-icon inline-items\"  id=\"Great\" onclick='Great("+data[0].aId+")'>\n" +
                                    "\t\t\t\t\t\t\t<svg class=\"olymp-heart-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-heart-icon\"></use></svg>\n" +
                                    // "\t\t\t\t\t\t\t<img src=\"/img/great.png\" >\n" +
                                    "\t\t\t\t\t\t\t<span  id=\"Great"+data[0].aId+"\"  >"+data[0].greatNum+"</span>\n" +
                                    "\t\t\t\t\t\t</a>\n" +
                                    "\t\t\t\t\t\t<div class=\"comments-shared\" id=\"a\">\n" +
                                    "\t\t\t\t\t\t\t<a   class=\"post-add-icon inline-items\" id=\"commentShow\"  onclick='comments("+data[0].aId+")'  >\n" +
                                    "\t\t\t\t\t\t\t\t<svg class=\"olymp-speech-balloon-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-speech-balloon-icon\"></use></svg>\n" +
                                    // "\t\t\t\t\t\t\t\t<img src=\"/img/comment.png\">\n" +
                                    "\t\t\t\t\t\t\t\t<span>查看评论</span>\n" +
                                    "\t\t\t\t\t\t\t</a>\n" +
                                    "\n" +
                                    "\t\t\t\t\t\t\t<a href=\"#\" class=\"post-add-icon inline-items\">\n" +
                                    "\t\t\t\t\t\t\t\t<svg class=\"olymp-share-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-share-icon\"></use></svg>\n" +
                                    "\t\t\t\t\t\t\t\t<span ></span>\n" +
                                    "\t\t\t\t\t\t\t</a>\n" +
                                    "\t\t\t\t\t\t</div>\n" +
                                    "\n" +
                                    "\n" +
                                    "\t\t\t\t\t</div>\n" +
                                    "\n" +
                                    "\t\t\t\t\t<div class=\"control-block-button post-control-button\">\n" +
                                    "\n" +
                                    "\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-control\">\n" +
                                    "\t\t\t\t\t\t\t<svg class=\"olymp-like-post-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-like-post-icon\"></use></svg>\n" +
                                    "\t\t\t\t\t\t</a>\n" +
                                    "\n" +
                                    "\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-control\">\n" +
                                    "\t\t\t\t\t\t\t<svg class=\"olymp-comments-post-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-comments-post-icon\"></use></svg>\n" +
                                    "\t\t\t\t\t\t</a>\n" +
                                    "\n" +
                                    "\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-control\">\n" +
                                    "\t\t\t\t\t\t\t<svg class=\"olymp-share-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-share-icon\"></use></svg>\n" +
                                    "\t\t\t\t\t\t</a>\n" +
                                    "\n" +
                                    "\t\t\t\t\t</div>\n" +
                                    "\n" +
                                    "\t\t\t\t</article>\n" +
                                    "\n" +
                                    "<div id=\"comments"+data[0].aId+"\">"+
                                    "\t\t\t\t\t</div>\n" +
                                    "");
                            }
                        })

                    },error:function (e) {
                        console.log(e)
                    }

                })
            }


        console.log("userId:"+userId)
        $("input[type=reset]").trigger("click");//触发reset
    })

    //查询所有帖子
    function select() {
        $.ajax({
            url: "/api/articleUserList",
            type: "get",
            dataType: "json",
            success: function (data)//回调
            {
                console.log(data)
                $.each(data, function (index, item) {
                    $("#d2").append("\t<div class=\"ui-block\" id=\"d3\">\n" +
                        "\n" +
                        "\n" +
                        "\t\t\t\t<article class=\"hentry post\">\n" +
                        "\n" +
                        "\t\t\t\t\t<div class=\"post__author author vcard inline-items\">\n" +
                        "\t\t\t\t\t\t<img src=\"/img/avatar10-sm.jpg\" alt=\"author\">\n" +
                        "\n" +
                        "\t\t\t\t\t\t<div class=\"author-date\">\n" +
                        "\t\t\t\t\t\t\t<a class=\"h6 post__author-name fn\" href=\"#\">"+item.nickName+"</a>\n" +
                        "\t\t\t\t\t\t\t<div class=\"post__date\">\n" +
                        "\t\t\t\t\t\t\t\t<time class=\"published\" datetime=\"2004-07-24T18:18\" >\n" + item.createTime +
                        "\n" +
                        "\t\t\t\t\t\t\t\t</time>\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t<div class=\"more\"><svg class=\"olymp-three-dots-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-three-dots-icon\"></use></svg>\n" +
                        "\t\t\t\t\t\t\t<ul class=\"more-dropdown\">\n" +
                        "\t\t\t\t\t\t\t\t<li>\n" +
                        "\t\t\t\t\t\t\t\t\t<a href=\"#\">Edit Post</a>\n" +
                        "\t\t\t\t\t\t\t\t</li>\n" +
                        "\t\t\t\t\t\t\t\t<li>\n" +
                        "\t\t\t\t\t\t\t\t\t<a href=\"#\">Delete Post</a>\n" +
                        "\t\t\t\t\t\t\t\t</li>\n" +
                        "\t\t\t\t\t\t\t\t<li>\n" +
                        "\t\t\t\t\t\t\t\t\t<a href=\"#\">Turn Off Notifications</a>\n" +
                        "\t\t\t\t\t\t\t\t</li>\n" +
                        "\t\t\t\t\t\t\t\t<li>\n" +
                        "\t\t\t\t\t\t\t\t\t<a href=\"#\">Select as Featured</a>\n" +
                        "\t\t\t\t\t\t\t\t</li>\n" +
                        "\t\t\t\t\t\t\t</ul>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t<p>\n" + item.content +
                        "\t\t\t\t\t</p>\n" +
                        "\n" +
                        "\t\t\t\t\t<div class=\"post-thumb\">\n" +
                        "\t\t\t\t\t\t<img src=\"" + item.url + "\" alt=''>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t<div class=\"post-additional-info inline-items\" >\n" +
                        "\n" +
                        "\t\t\t\t\t\t<a class=\"post-add-icon inline-items\"  id=\"Great\" onclick='Great("+item.aId+")'>\n" +
                        "\t\t\t\t\t\t\t<svg class=\"olymp-heart-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-heart-icon\"></use></svg>\n" +
                        // "\t\t\t\t\t\t\t<img src=\"/img/great.png\" >\n" +
                        "\t\t\t\t\t\t\t<span value=\""+item.greatNum+"\" id=\"Great"+item.aId+"\" >"+item.greatNum+"</span>\n" +
                        "\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t\t<div class=\"comments-shared\" id=\"a\">\n" +
                        "\t\t\t\t\t\t\t<a   class=\"post-add-icon inline-items\" id=\"commentShow\" onclick='comments("+item.aId+")'  >\n" +
                        "\t\t\t\t\t\t\t\t<svg class=\"olymp-speech-balloon-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-speech-balloon-icon\"></use></svg>\n" +
                        // "\t\t\t\t\t\t\t\t<img src=\"/img/comment.png\">\n" +
                        "\t\t\t\t\t\t\t<span>查看评论</span>\n" +
                        "\t\t\t\t\t\t\t</a>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t<a href=\"#\" class=\"post-add-icon inline-items\">\n" +
                        "\t\t\t\t\t\t\t\t<svg class=\"olymp-share-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-share-icon\"></use></svg>\n" +
                        "\t\t\t\t\t\t\t\t<span ></span>\n" +
                        "\t\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t<div class=\"control-block-button post-control-button\">\n" +
                        "\n" +
                        "\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-control\">\n" +
                        "\t\t\t\t\t\t\t<svg class=\"olymp-like-post-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-like-post-icon\"></use></svg>\n" +
                        "\t\t\t\t\t\t</a>\n" +
                        "\n" +
                        "\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-control\">\n" +
                        "\t\t\t\t\t\t\t<svg class=\"olymp-comments-post-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-comments-post-icon\"></use></svg>\n" +
                        "\t\t\t\t\t\t</a>\n" +
                        "\n" +
                        "\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-control\">\n" +
                        "\t\t\t\t\t\t\t<svg class=\"olymp-share-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-share-icon\"></use></svg>\n" +
                        "\t\t\t\t\t\t</a>\n" +
                        "\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t</article>\n" +
                        "\n" +
                        "<div id=\"comments"+item.aId+"\">"+
                        "\t\t\t\t\t</div>\n" +
                        "")
                })

            }

        })


    }






})