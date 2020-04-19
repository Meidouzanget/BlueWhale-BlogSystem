package com.melcoc.bluewhale.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class Userinfo implements Serializable {
    private Integer uid;

    private String uname;

    private String upsw;

    private String usealname;

    private static final long serialVersionUID = 1L;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpsw() {
        return upsw;
    }

    public void setUpsw(String upsw) {
        this.upsw = upsw == null ? null : upsw.trim();
    }

    public String getUsealname() {
        return usealname;
    }

    public void setUsealname(String usealname) {
        this.usealname = usealname == null ? null : usealname.trim();
    }
}