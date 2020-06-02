package com.melcoc.bluewhale.service;

import com.melcoc.bluewhale.domain.CommentReply;

import java.util.List;

public interface CommentReplyService {
    /**
     * 全查
     * @return
     */
    List<CommentReply> selectCommentReplyAll();
    /**
     * 添加
     */
    int insertCommentReply(CommentReply commentReply);
}
