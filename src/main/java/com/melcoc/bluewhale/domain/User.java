package com.melcoc.bluewhale.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@TableName("user")
public class User {

  @TableId(type = IdType.AUTO)
  private long userId;
  private String name;
  private String nickName;
  private String birth;
  private long sex;
  private String signature;
  private String avatar;
  private String phone;
  private String email;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private String createIp;
  private long status;
  @TableLogic
  private long deleted;

  private LUser lUser;


}
