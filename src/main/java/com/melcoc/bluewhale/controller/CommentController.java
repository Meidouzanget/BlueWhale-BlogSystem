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

import java.time.LocalDateTime;
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
    public String addComment(@Param("userId") int userId,@Param("answerId") int answerId,String content,Model model){
        Comment comment=new Comment();
        comment.setAnswerId(answerId);//文章ID
        comment.setUserId(userId);//用户ID
        comment.setContent(content);//评论内容

        commentService.insertComment(comment);//发表评论
        System.out.println(comment.toString());
        CommentServiceImpl commentService=new CommentServiceImpl();
        List<Comment> list=   commentService.selectCommentAll(answerId);
            model.addAttribute("commentList",list);
        return "MainPage";
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
    public  String selectAllComment(@Param("answerId") int answerId, Model model){
       List<Comment> list= commentService.selectCommentAll(answerId);
        List<Article> list2=articleService.selectArticleAll();
        model.addAttribute("articlelist",list2);
     Model model1=model.addAttribute("commentList",list);
        System.out.println(list);
        System.out.println(model1);
        return "MainPage";
    }
}
