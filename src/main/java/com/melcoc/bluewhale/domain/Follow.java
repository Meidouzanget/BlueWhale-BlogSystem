package com.melcoc.bluewhale.domain;

import java.sql.Timestamp;

public class Follow {
    private int follow_id;
    private int follow_u_id;//关注者编号
    private int followed_u_id;//被关注者编号
    private byte check_status;
    private Timestamp create_time;
    private Timestamp modify_time;


}
