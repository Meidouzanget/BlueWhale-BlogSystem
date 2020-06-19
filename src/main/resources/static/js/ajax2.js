// function selectUserAll() {
//     var uId2=2;
//     $.ajax({
//         url:"/article/selectUserAll",
//         type:"get",
//         data: {
//
//     },
//         dataType:"json",
//         success:function (data) {
//
//         }
//     )}
//
// }

$(function () {



function select() {
    $.ajax({
        url: "/article/selectUserAll",
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
                    "\t\t\t\t\t\t\t<a   class=\"post-add-icon inline-items\" id=\"commentShow\" onclick='comments("+item.aId+")'  >\n" +
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
                    "<div id=\"comments"+item.aId+"\">"+
                    "\t\t\t\t\t</div>\n" +
                    "")
            })

        }

    })


}

})
