package com.melcoc.bluewhale.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.dao.CommentReplyDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.CommentReply;
import com.melcoc.bluewhale.service.CommentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentReplyServiceImpl implements CommentReplyService {
    @Autowired
    CommentReplyDao commentReplyDao;


    @Async
    @Override
    public List<CommentReply> selectCommentReplyAll(int commentId,int userId) {
        QueryWrapper wrapper = new QueryWrapper<Article>();
        wrapper.eq("comment_id",commentId);
        wrapper.eq("user_id",userId);
        wrapper.eq("deleted",1);
        return commentReplyDao.selectList(wrapper);
    }

    @Async
    @Override
    public int insertCommentReply(CommentReply commentReply) {
        return commentReplyDao.insert(commentReply);
    }


//    @Override
//    public int deletedCommentReply(Integer userId) {
//        return commentReplyDao.deletedCommentReply(userId);
//    }
}
