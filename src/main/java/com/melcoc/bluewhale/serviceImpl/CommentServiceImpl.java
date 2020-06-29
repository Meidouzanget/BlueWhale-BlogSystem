package com.melcoc.bluewhale.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.dao.CommentDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Comment;
import com.melcoc.bluewhale.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Async("taskExecutor")
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;


    @Override
    public Future<List> selectCommentAll(int answerId) {
        QueryWrapper wrapper = new QueryWrapper<Article>();
        wrapper.eq("answer_id",answerId);
        wrapper.eq("deleted",0);
        return new AsyncResult<>(commentDao.selectList(wrapper));
    }


    @Override
    public Future<Integer> insertComment(Comment comment) {

        return new AsyncResult<>(commentDao.insert(comment));
    }


    @Override
    public Future<Integer> deletedComment(Integer commentId) {

        return new AsyncResult<>(commentDao.deletedComment(commentId));
    }


    @Override
    public Future<List<Comment>> userCommentList(int answerId) {

        return new AsyncResult<>(commentDao.userCommentList(answerId));
    }


    @Override
    public Future<List<Comment>> userComment(int answerId) {

        return new AsyncResult<>(commentDao.userComment(answerId));
    }


}
