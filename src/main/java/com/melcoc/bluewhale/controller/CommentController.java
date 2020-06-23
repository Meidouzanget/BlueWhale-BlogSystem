package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Comment;
import com.melcoc.bluewhale.serviceImpl.ArticleServiceImpl;
import com.melcoc.bluewhale.serviceImpl.CommentServiceImpl;
import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @Autowired
    ArticleServiceImpl articleService;



    /**
     * 发表评论
     *
     */
    @ApiOperation("发表评论")
    @PostMapping("/api/addComment")
    public  Comment addComment(@Param("userId") int userId,@Param("answerId") int answerId,String content){
        Comment comment=new Comment();
        comment.setAnswerId(answerId);//文章ID
        comment.setUserId(userId);//用户ID
        comment.setContent(content);//评论内容

        commentService.insertComment(comment);//发表评论
        System.out.println(comment.toString());
        return comment;
    }
    /**
     * 查询最新一条评论
     */
    @ApiOperation("查询最新一条评论")
    @PostMapping("/api/userComment")
    public  List<Comment> userComment(int answerId){
        List<Comment> list= commentService.userComment(answerId);
        return list;
    }



    /**
     * 逻辑删除
     */
    @ApiOperation("逻辑删除")
    @PostMapping("/api/delComment")
    public String deletedComment(@Param("commentId") int commentId){
        commentService.deletedComment(commentId);
        return "删除成功";
    }
    /**
     *查询
     */
    @ApiOperation("查询")
    @PostMapping("/api/selectAllComment")
    public   List<Comment>  selectAllComment(@Param("answerId") int answerId){
        List<Comment> list= commentService.userCommentList(answerId);
        System.out.println(list);

        return list;
    }
}
