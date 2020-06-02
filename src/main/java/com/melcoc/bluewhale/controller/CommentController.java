package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.Comment;
import com.melcoc.bluewhale.serviceImpl.CommentServiceImpl;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;


    /**
     * 发表评论
     *
     */
    @RequestMapping("addComment")
    public String addComment(Comment comment){
       comment.setAnswerId(comment.getAnswerId());//文章ID
        comment.setUserId(comment.getUserId());//用户ID
        comment.setContent(comment.getContent());//评论内容
        comment.setState(1);//状态
        comment.setGreatCount(0);//点赞数
        comment.setCreateTime(LocalDateTime.now());//评论时间
        comment.setUpdateTime(LocalDateTime.now());//更新时间
        comment.setDeleted(1);//逻辑删除

        commentService.insertComment(comment);//发表评论


        return "评论成功";
    }
    /**
     * 逻辑删除
     */
    @RequestMapping("delComment")
    public String deletedComment(@Param("commentId") int commentId){
        commentService.deletedComment(commentId);
        return "删除成功";
    }
}
