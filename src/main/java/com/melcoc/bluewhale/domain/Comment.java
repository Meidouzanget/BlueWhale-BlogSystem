package com.melcoc.bluewhale.domain;

import java.time.LocalDateTime;

public class Comment {
    private int commentId;
    private int answerId;
    private int userId;
    private String content;
    private int state;
    private int greatCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private int deleted;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", answerId=" + answerId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", greatCount=" + greatCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Comment() {
    }

    public Comment(int commentId, int answerId, int userId, String content, int state, int greatCount, LocalDateTime createTime, LocalDateTime updateTime, int deleted) {
        this.commentId = commentId;
        this.answerId = answerId;
        this.userId = userId;
        this.content = content;
        this.state = state;
        this.greatCount = greatCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }
}
