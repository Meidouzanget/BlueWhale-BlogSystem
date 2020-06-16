package com.melcoc.bluewhale.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@TableName("l_userrole")
public class LUserrole {

  @TableId(value = "",type = IdType.AUTO)
  private long urid;
  private long uid;
  private long rid;

  public LUserrole(long uid, long rid) {
    this.uid = uid;
    this.rid = rid;
  }

  public long getUrid() {
    return urid;
  }

  public void setUrid(long urid) {
    this.urid = urid;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public long getRid() {
    return rid;
  }

  public void setRid(long rid) {
    this.rid = rid;
  }

}
