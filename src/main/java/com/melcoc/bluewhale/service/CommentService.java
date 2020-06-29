package com.melcoc.bluewhale.service;


import com.melcoc.bluewhale.domain.Comment;

import java.util.List;
import java.util.concurrent.Future;

public interface CommentService {
    /**
     * 全查
     * @return
     */
    Future<List> selectCommentAll(int answerId);
    /**
     * 添加
     * @return
     */
    Future<Integer> insertComment(Comment comment);
    /**
     * 逻辑删除
     * @return
     */
    Future deletedComment(Integer commentId);

    /**
     * 带用户表的全查
     * @param answerId
     * @return
     */
    Future<List<Comment>> userCommentList(int answerId);

    Future<List<Comment>> userComment(int answerId);
}
