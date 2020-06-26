package com.melcoc.bluewhale.service;

import com.melcoc.bluewhale.domain.LUser;
import com.melcoc.bluewhale.domain.LUserrole;
import com.melcoc.bluewhale.domain.User;

public interface UserService {
    //登录查询
    LUser getUserWithPermission(String account);
    //注册-用户名/邮箱地址重复查询
    boolean getUserNameNoRepeat(String username);
    boolean getUserEmailNoRepeat(String email);

    //注册
    boolean register(User userBean, LUser lUserBean);

    //修改密码
    boolean changePassword(LUser lUser);

    User selectUserByName(String username);

    LUser selectlUserByName(String username);

    boolean insertUserrole(LUserrole lUserrole);



    /**
     * 根据UserId修改avatar
     */

    boolean updateByIdUser(User user);

    boolean updateByIduUrl(int userId,String avatar);

    int selectUserId(String name);

}
