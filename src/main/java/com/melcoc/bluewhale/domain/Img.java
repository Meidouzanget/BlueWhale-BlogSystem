package com.melcoc.bluewhale.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Img {
    private int img_id;
    private String url;
    private int a_id;
    private int u_id;
    private LocalDateTime create_time;
}
