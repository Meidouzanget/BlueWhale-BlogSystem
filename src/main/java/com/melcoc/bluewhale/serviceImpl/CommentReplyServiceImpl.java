package com.melcoc.bluewhale.serviceImpl;

import com.melcoc.bluewhale.dao.CommentDao;
import com.melcoc.bluewhale.dao.CommentReplyDao;
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
    public List<CommentReply> selectCommentReplyAll() {
        return commentReplyDao.selectList(null);
    }

    @Override
    public int insertCommentReply(CommentReply commentReply) {
        return commentReplyDao.insert(commentReply);
    }
}
