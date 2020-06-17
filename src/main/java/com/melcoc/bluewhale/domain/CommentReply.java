package com.melcoc.bluewhale.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;

import java.time.LocalDateTime;

public class CommentReply {
    private int commentId;
    private int userId;
    private int replyUserId;
    private String content;
    private int greatCount;
    private LocalDateTime createTime;
    @TableLogic
    private int deleted;

    @Override
    public String toString() {
        return "CommentReply{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", replyUserId=" + replyUserId +
                ", content='" + content + '\'' +
                ", greatCount=" + greatCount +
                ", createTime=" + createTime +
                ", deleted=" + deleted +
                '}';
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(int replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getGreatCount() {
        return greatCount;
    }

    public void setGreatCount(int greatCount) {
        this.greatCount = greatCount;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public CommentReply(int commentId, int userId, int replyUserId, String content, int greatCount, LocalDateTime createTime, int deleted) {
        this.commentId = commentId;
        this.userId = userId;
        this.replyUserId = replyUserId;
        this.content = content;
        this.greatCount = greatCount;
        this.createTime = createTime;
        this.deleted = deleted;
    }

    public CommentReply() {
    }
}
