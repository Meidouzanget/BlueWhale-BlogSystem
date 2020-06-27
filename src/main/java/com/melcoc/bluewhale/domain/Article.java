package com.melcoc.bluewhale.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.time.LocalDateTime;


public class Article {
    @TableId(type = IdType.AUTO)
    private int aId; //信息编号
    private int userId;//用户编号
    private LocalDateTime createTime;//发布日期
    private String content;//内容
    @TableLogic
    private int deleted;//逻辑删除
    private int greatNum;//点赞数
    private String url;//图片路径

    @TableField(exist = false)
    private String name;
    @TableField(exist = false)
    private String nickName;


    @Override
    public String toString() {
        return "Article{" +
                "aId=" + aId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", deleted=" + deleted +
                ", greatNum=" + greatNum +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getGreatNum() {
        return greatNum;
    }

    public void setGreatNum(int greatNum) {
        this.greatNum = greatNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Article() {
    }

    public Article(int aId, int userId, LocalDateTime createTime, String content, int deleted, int greatNum, String url, String name, String nickName) {
        this.aId = aId;
        this.userId = userId;
        this.createTime = createTime;
        this.content = content;
        this.deleted = deleted;
        this.greatNum = greatNum;
        this.url = url;
        this.name = name;
        this.nickName = nickName;
    }
}
