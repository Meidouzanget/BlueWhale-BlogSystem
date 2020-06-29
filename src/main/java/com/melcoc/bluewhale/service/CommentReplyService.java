package com.melcoc.bluewhale.service;

import com.melcoc.bluewhale.domain.CommentReply;

import java.util.List;
import java.util.concurrent.Future;

public interface CommentReplyService {
    /**
     * 全查
     * @return
     */
    Future<List<CommentReply>> selectCommentReplyAll(int commentId, int userId);
    /**
     * 添加
     * @return
     */
    Future<Integer> insertCommentReply(CommentReply commentReply);
//    /**
//     * 逻辑删除
//     */
//    int deletedCommentReply(Integer userId);
}
