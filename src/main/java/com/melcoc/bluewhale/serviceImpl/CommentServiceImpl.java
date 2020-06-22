package com.melcoc.bluewhale.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.dao.ArticleDao;
import com.melcoc.bluewhale.dao.CommentDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Comment;
import com.melcoc.bluewhale.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public List<Comment> selectCommentAll(int answerId) {
        QueryWrapper wrapper = new QueryWrapper<Article>();
        wrapper.eq("answer_id",answerId);
        wrapper.eq("deleted",0);
        return commentDao.selectList(wrapper);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentDao.insert(comment);
    }

    @Override
    public int deletedComment(Integer commentId) {
        return commentDao.deletedComment(commentId);
    }

    @Override
    public List<Comment> userCommentList(int answerId) {
        return commentDao.userCommentList(answerId);
    }
}
