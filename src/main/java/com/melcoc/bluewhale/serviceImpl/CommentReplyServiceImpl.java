package com.melcoc.bluewhale.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.dao.CommentReplyDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.CommentReply;
import com.melcoc.bluewhale.service.CommentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Async("taskExecutor")
@Service
public class CommentReplyServiceImpl implements CommentReplyService {
    @Autowired
    CommentReplyDao commentReplyDao;



    @Override
    public Future<List<CommentReply>> selectCommentReplyAll(int commentId, int userId) {
        QueryWrapper wrapper = new QueryWrapper<Article>();
        wrapper.eq("comment_id",commentId);
        wrapper.eq("user_id",userId);
        wrapper.eq("deleted",1);
        return new AsyncResult<>(commentReplyDao.selectList(wrapper));
    }


    @Override
    public Future<Integer> insertCommentReply(CommentReply commentReply) {

        return new AsyncResult<>(commentReplyDao.insert(commentReply));
    }


//    @Override
//    public int deletedCommentReply(Integer userId) {
//        return commentReplyDao.deletedCommentReply(userId);
//    }
}
