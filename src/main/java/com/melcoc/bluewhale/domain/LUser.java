package com.melcoc.bluewhale.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.List;

@Data
public class LUser {

  @TableId(value = "",type = IdType.AUTO)
  private long uid;
  private String account;
  private String name;
  private String password;
  private long rid;
  @TableLogic
  private  int deleted;

  /**
   * 角色
   */
  private LRole role;

  /**
   * 权限列表
   */
  private List<LPermission> permissions;

}
