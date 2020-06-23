package com.melcoc.bluewhale.service;

import com.melcoc.bluewhale.domain.LUser;
import com.melcoc.bluewhale.domain.LUserrole;
import com.melcoc.bluewhale.domain.User;

public interface UserService {

    LUser getUserWithPermission(String account);

    boolean getUserNameNoRepeat(String username);
    boolean getUserEmailNoRepeat(String email);

    //注册
    boolean register(User userBean, LUser lUserBean);

    User selectUserByName(String username);

    LUser selectlUserByName(String username);

    boolean insertUserrole(LUserrole lUserrole);

    /**
     * 修改个人信息
     */
    int updateByIdUser(User user);
}
