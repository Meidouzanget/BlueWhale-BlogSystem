package com.melcoc.bluewhale.serviceImpl;

import com.melcoc.bluewhale.dao.ArticleDao;
import com.melcoc.bluewhale.dao.CommentDao;
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
    public List<Comment> selectCommentAll() {
        return commentDao.selectList(null);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentDao.insert(comment);
    }

    @Override
    public int deletedComment(Integer commentId) {
        return commentDao.deletedComment(commentId);
    }
}
