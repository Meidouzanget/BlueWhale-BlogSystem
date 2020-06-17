function Great(greatId) {
    var userId=1;
    var aId=greatId;
    var gid = "#Great"+greatId;
    let val = $(gid).html();
    let sum =0;
    sum=parseInt(val)+1;
    $(gid).text(sum);
    console.log(sum);
    console.log("gid"+gid)
    console.log("aId:"+aId);
    $.ajax({
        url: "/article/great",
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
    var result = "";
    var userId=1;
    //图片加载
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

            $.ajax({
                url: "/article/addArticle",
                type: "post",
                data: {
                    base64Date: result,
                    content: content,
                    userId: userId
                },
                dataType: "json",
                success: function (e) {
                    console.log(e)
                    $("#d3").prepend("\t<div class=\"ui-block\">\n" +
                        "\n" +
                        "\n" +
                        "\t\t\t\t<article class=\"hentry post\">\n" +
                        "\n" +
                        "\t\t\t\t\t<div class=\"post__author author vcard inline-items\">\n" +
                        "\t\t\t\t\t\t<img src=\"/img/avatar10-sm.jpg\" alt=\"author\">\n" +
                        "\n" +
                        "\t\t\t\t\t\t<div class=\"author-date\">\n" +
                        "\t\t\t\t\t\t\t<a class=\"h6 post__author-name fn\" href=\"#\">Elaine Dreyfuss</a>\n" +
                        "\t\t\t\t\t\t\t<div class=\"post__date\">\n" +
                        "\t\t\t\t\t\t\t\t<time class=\"published\" datetime=\"2004-07-24T18:18\" >\n" + e.createTime +
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
                        "\t\t\t\t\t<p>\n" + e.content +
                        "\t\t\t\t\t</p>\n" +
                        "\n" +
                        "\t\t\t\t\t<div class=\"post-thumb\">\n" +
                        "\t\t\t\t\t\t<img src=\"" + e.url + "\" alt=''>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t<div class=\"post-additional-info inline-items\" >\n" +
                        "\n" +
                        "\t\t\t\t\t\t<a class=\"post-add-icon inline-items\"  id=\"Great\" onclick='Great("+e.aId+")'>\n" +
                        "\t\t\t\t\t\t\t<svg class=\"olymp-heart-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-heart-icon\"></use></svg>\n" +
                        "\t\t\t\t\t\t\t<img src=\"/img/great.png\" >\n" +
                        "\t\t\t\t\t\t\t<span  id=\"Great"+e.aId+"\"  >"+e.greatNum+"</span>\n" +
                        "\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t\t<div class=\"comments-shared\" id=\"a\">\n" +
                        "\t\t\t\t\t\t\t<a   class=\"post-add-icon inline-items\" id=\"commentShow\" th:href=\"@{/comment/selectAllComment(answerId=${li.getaId()})}\"  >\n" +
                        "\t\t\t\t\t\t\t\t<svg class=\"olymp-speech-balloon-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-speech-balloon-icon\"></use></svg>\n" +
                        "\t\t\t\t\t\t\t\t<img src=\"/img/comment.png\">\n" +
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
                        "\t\t\t\t<!-- Comments -->\n" +
                        "\t\t\t\t<div id=\"comments\" >\n" +
                        "\t\t\t\t\t<ul class=\"comments-list\"  >\n" +
                        "\t\t\t\t\t\t<li class=\"comment-item\" >\n" +
                        "\t\t\t\t\t\t\t<div class=\"post__author author vcard inline-items\">\n" +
                        "\t\t\t\t\t\t\t\t<img th:src=\"@{author-page.jpg}\" alt=\"author\">\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"author-date\">\n" +
                        "\t\t\t\t\t\t\t\t\t<a class=\"h6 post__author-name fn\" href=\"02-ProfilePage.html\">James Spiegel</a>\n" +
                        "\t\t\t\t\t\t\t\t\t<div class=\"post__date\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<time class=\"published\" datetime=\"2004-07-24T18:18\" th:text=\"${comments.createTime}\">\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t\t\t</time>\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t<a href=\"#\" class=\"more\"><svg class=\"olymp-three-dots-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-three-dots-icon\"></use></svg></a>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t<p></p>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t<a href=\"#\" class=\"post-add-icon inline-items\">\n" +
                        "\t\t\t\t\t\t\t\t<svg class=\"olymp-heart-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-heart-icon\"></use></svg>\n" +
                        "\t\t\t\t\t\t\t\t<span>3</span>\n" +
                        "\t\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t\t\t<a href=\"#\" class=\"reply\">Reply</a>\n" +
                        "\t\t\t\t\t\t</li>\n" +
                        "\n" +
                        "\t\t\t\t\t</ul>\n" +
                        "\n" +
                        "\t\t\t\t\t<!-- ... end Comments -->\n" +
                        "\n" +
                        "\t\t\t\t\t<!--\t\t\t\t\t<a href=\"#\" class=\"more-comments\">View more comments <span>+</span></a>-->\n" +
                        "\n" +
                        "\n" +
                        "\t\t\t\t\t<!-- Comment Form  -->\n" +
                        "\n" +
                        "\t\t\t\t\t<form class=\"comment-form inline-items\"   >\n" +
                        "\n" +
                        "\t\t\t\t\t\t<div class=\"post__author author vcard inline-items\">\n" +
                        "\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t<div class=\"form-group with-icon-right \">\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t<textarea class=\"form-control\" placeholder=\"\"  name=\"content\"></textarea>\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"add-options-message\">\n" +
                        "\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"options-message\" data-toggle=\"modal\" data-target=\"#update-header-photo\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<svg class=\"olymp-camera-icon\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<use xlink:href=\"svg-icons/sprites/icons.svg#olymp-camera-icon\"></use>\n" +
                        "\t\t\t\t\t\t\t\t\t\t</svg>\n" +
                        "\t\t\t\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t<button class=\"btn btn-md-2 btn-primary\"  id='postComment' >发表评论</button>\n" +
                        "\n" +
                        "\t\t\t\t\t\t<button class=\"btn btn-md-2 btn-border-think c-grey btn-transparent custom-color\">Cancel</button>\n" +
                        "\n" +
                        "\t\t\t\t\t</form>\n" +
                        "\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t<!-- ... end Comment Form  -->\n" +
                        "\t\t\t</div>");
                },error:function (e) {
                    console.log(e)
                }

            })

        console.log("userId:"+userId)

    })
    //查询所有帖子
    function select() {
        $.ajax({
            url: "/article/allArticle",
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
                        "\t\t\t\t\t\t\t<a class=\"h6 post__author-name fn\" href=\"#\">Elaine Dreyfuss</a>\n" +
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
                        "\t\t\t\t\t\t\t<img src=\"/img/great.png\" >\n" +
                        "\t\t\t\t\t\t\t<span value=\""+item.greatNum+"\" id=\"Great"+item.aId+"\" >"+item.greatNum+"</span>\n" +
                        "\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t\t<div class=\"comments-shared\" id=\"a\">\n" +
                        "\t\t\t\t\t\t\t<a   class=\"post-add-icon inline-items\" id=\"commentShow\" th:href=\"@{/comment/selectAllComment(answerId=${li.getaId()})}\"  >\n" +
                        "\t\t\t\t\t\t\t\t<svg class=\"olymp-speech-balloon-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-speech-balloon-icon\"></use></svg>\n" +
                        "\t\t\t\t\t\t\t\t<img src=\"/img/comment.png\">\n" +
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
                        "\t\t\t\t<!-- Comments -->\n" +
                        "\t\t\t\t<div id=\"comments\" >\n" +
                        "\t\t\t\t\t<ul class=\"comments-list\"  >\n" +
                        "\t\t\t\t\t\t<li class=\"comment-item\" >\n" +
                        "\t\t\t\t\t\t\t<div class=\"post__author author vcard inline-items\">\n" +
                        "\t\t\t\t\t\t\t\t<img th:src=\"@{author-page.jpg}\" alt=\"author\">\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"author-date\">\n" +
                        "\t\t\t\t\t\t\t\t\t<a class=\"h6 post__author-name fn\" href=\"02-ProfilePage.html\">James Spiegel</a>\n" +
                        "\t\t\t\t\t\t\t\t\t<div class=\"post__date\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<time class=\"published\" datetime=\"2004-07-24T18:18\" th:text=\"${comments.createTime}\">\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t\t\t</time>\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t<a href=\"#\" class=\"more\"><svg class=\"olymp-three-dots-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-three-dots-icon\"></use></svg></a>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t<p></p>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t<a href=\"#\" class=\"post-add-icon inline-items\">\n" +
                        "\t\t\t\t\t\t\t\t<svg class=\"olymp-heart-icon\"><use xlink:href=\"svg-icons/sprites/icons.svg#olymp-heart-icon\"></use></svg>\n" +
                        "\t\t\t\t\t\t\t\t<span>3</span>\n" +
                        "\t\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t\t\t<a href=\"#\" class=\"reply\">Reply</a>\n" +
                        "\t\t\t\t\t\t</li>\n" +
                        "\n" +
                        "\t\t\t\t\t</ul>\n" +
                        "\n" +
                        "\t\t\t\t\t<!-- ... end Comments -->\n" +
                        "\n" +
                        "\t\t\t\t\t<!--\t\t\t\t\t<a href=\"#\" class=\"more-comments\">View more comments <span>+</span></a>-->\n" +
                        "\n" +
                        "\n" +
                        "\t\t\t\t\t<!-- Comment Form  -->\n" +
                        "\n" +
                        "\t\t\t\t\t<form class=\"comment-form inline-items\"   >\n" +
                        "\n" +
                        "\t\t\t\t\t\t<div class=\"post__author author vcard inline-items\">\n" +
                        "\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t<div class=\"form-group with-icon-right \">\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t<textarea class=\"form-control\" placeholder=\"\"  name=\"content\"></textarea>\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"add-options-message\">\n" +
                        "\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"options-message\" data-toggle=\"modal\" data-target=\"#update-header-photo\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<svg class=\"olymp-camera-icon\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<use xlink:href=\"svg-icons/sprites/icons.svg#olymp-camera-icon\"></use>\n" +
                        "\t\t\t\t\t\t\t\t\t\t</svg>\n" +
                        "\t\t\t\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t<button class=\"btn btn-md-2 btn-primary\"  id='postComment' >发表评论</button>\n" +
                        "\n" +
                        "\t\t\t\t\t\t<button class=\"btn btn-md-2 btn-border-think c-grey btn-transparent custom-color\">Cancel</button>\n" +
                        "\n" +
                        "\t\t\t\t\t</form>\n" +
                        "\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t<!-- ... end Comment Form  -->\n" +
                        "\t\t\t</div>")
                })

            }

        })


    }


    //评论
    $("#postComment").on('click', function () {
        alert("评论")
        // $.ajax({
        //     url: "/comment/addComment",
        //     type: "post",
        //     data: {
        //         userId: userId,
        //         answerId: answerId,
        //         content: content
        //     },
        //     dataType: "json",
        //     success: function (e) {
        //
        //     },error:function (e) {
        //         console.log(e)
        //     }
        //
        // })

        console.log("userId:"+userId)

    })

    //点赞
    $(document).ready(function() {
        $("#clickGreat").click(function(){
            alert("点赞")
        });
    });

})