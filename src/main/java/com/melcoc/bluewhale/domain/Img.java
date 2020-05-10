package com.melcoc.bluewhale.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Img {
    private int imgId;
    private String url;
    private int aId;
    private int uId;
    private LocalDateTime createTime;
}
