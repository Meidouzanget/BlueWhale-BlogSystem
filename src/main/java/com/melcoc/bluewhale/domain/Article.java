package com.melcoc.bluewhale.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private int a_id; //信息编号
    private int user_id;//用户编号
    private LocalDateTime create_time;//发布日期
    private String content;//内容
    private int deleted;//逻辑删除

}
