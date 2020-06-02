package com.melcoc.bluewhale.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.dao.CommentDao;
import com.melcoc.bluewhale.dao.CommentReplyDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Comment;
import com.melcoc.bluewhale.domain.CommentReply;
import com.melcoc.bluewhale.service.CommentReplyService;
import com.melcoc.bluewhale.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentReplyServiceImpl implements CommentReplyService {
    @Autowired
    CommentReplyDao commentReplyDao;


    @Override
    public List<CommentReply> selectCommentReplyAll(int commentId,int userId) {
        QueryWrapper wrapper = new QueryWrapper<Article>();
        wrapper.eq("comment_id",commentId);
        wrapper.eq("user_id",userId);
        wrapper.eq("deleted",1);
        return commentReplyDao.selectList(wrapper);
    }

    @Override
    public int insertCommentReply(CommentReply commentReply) {
        return commentReplyDao.insert(commentReply);
    }

//    @Override
//    public int deletedCommentReply(Integer userId) {
//        return commentReplyDao.deletedCommentReply(userId);
//    }
}
