package com.gp.wu.graphtrip.Rbmob.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by wu on 2017/3/28.
 */

public class User extends BmobUser{
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
