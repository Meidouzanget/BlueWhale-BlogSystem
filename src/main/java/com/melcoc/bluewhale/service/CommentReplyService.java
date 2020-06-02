package com.melcoc.bluewhale.service;

import com.melcoc.bluewhale.domain.CommentReply;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommentReplyService {
    /**
     * 全查
     * @return
     */
    List<CommentReply> selectCommentReplyAll(int commentId,int userId);
    /**
     * 添加
     */
    int insertCommentReply(CommentReply commentReply);
//    /**
//     * 逻辑删除
//     */
//    int deletedCommentReply(Integer userId);
}
