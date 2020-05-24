package com.melcoc.bluewhale.domain;




public class Great {
    private int id;
    private int aId;
    private int uId;

    @Override
    public String toString() {
        return "Great{" +
                "id=" + id +
                ", aId=" + aId +
                ", uId=" + uId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public Great() {
    }

    public Great(int id, int aId, int uId) {
        this.id = id;
        this.aId = aId;
        this.uId = uId;
    }
}
