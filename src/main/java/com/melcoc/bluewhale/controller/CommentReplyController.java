package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.CommentReply;
import com.melcoc.bluewhale.serviceImpl.CommentReplyServiceImpl;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/commentReply")
@Async
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
    /**
     * 逻辑删除
     */
//    @RequestMapping("delCommentReply")
//    public String deletedCommentReply(@Param("userId") int userId){
//        commentReplyService.deletedCommentReply(userId);
//        return "删除成功";
//    }
    /**
     * 查询
     */
    @RequestMapping("/selectAllComment")
    public  String selectAllComment(@Param("commentId") int commentId,@Param("userId") int userId, Model model){
        List<CommentReply> list= commentReplyService.selectCommentReplyAll(commentId,userId);
        Model model1=model.addAttribute("commentReplyList",list);
        System.out.println(list);
        System.out.println(model1);
        return "";
    }

}
