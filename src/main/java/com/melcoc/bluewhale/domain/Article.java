package com.melcoc.bluewhale.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @TableId(type = IdType.INPUT)
    private int aId; //信息编号
    private int userId;//用户编号
    private LocalDateTime createTime;//发布日期
    private String content;//内容
    private int deleted;//逻辑删除

}
