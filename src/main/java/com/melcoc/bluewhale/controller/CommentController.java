package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Comment;
import com.melcoc.bluewhale.serviceImpl.ArticleServiceImpl;
import com.melcoc.bluewhale.serviceImpl.CommentServiceImpl;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @Autowired
    ArticleServiceImpl articleService;



    /**
     * 发表评论
     *
     */
    @RequestMapping("addComment")
    public @ResponseBody Comment addComment(@Param("userId") int userId,@Param("answerId") int answerId,String content){
        Comment comment=new Comment();
        comment.setAnswerId(answerId);//文章ID
        comment.setUserId(userId);//用户ID
        comment.setContent(content);//评论内容

        commentService.insertComment(comment);//发表评论
        System.out.println(comment.toString());
        return comment;
    }
    /**
     * 逻辑删除
     */
    @RequestMapping("delComment")
    public String deletedComment(@Param("commentId") int commentId){
        commentService.deletedComment(commentId);
        return "删除成功";
    }
    /**
     *查询
     */
    @RequestMapping("/selectAllComment")
    public  @ResponseBody List<Comment>  selectAllComment(@Param("answerId") int answerId){
        List<Comment> list= commentService.selectCommentAll(answerId);
        System.out.println(list);

        return list;
    }
}
