package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.CommentReply;
import com.melcoc.bluewhale.serviceImpl.CommentReplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/commentReply")
public class CommentReplyController {

    @Autowired
    CommentReplyServiceImpl commentReplyService;


    /**
     * 回复评论
     */
    @RequestMapping("/addCommentReply")
    public String addCommentReply(CommentReply commentReply){
        commentReply.setCommentId(commentReply.getCommentId());//获取文章ID
        commentReply.setUserId(5);//获取当前用户ID
        commentReply.setReplyUserId(6);//被回复ID
        commentReply.setContent(commentReply.getContent());//回复内容
        commentReply.setGreatCount(commentReply.getGreatCount());//点赞数
        commentReply.setCreateTime(LocalDateTime.now());//回复时间
        commentReply.setDeleted(1);//

        commentReplyService.insertCommentReply(commentReply);//回复评论
        return "评论成功";
    }
}
