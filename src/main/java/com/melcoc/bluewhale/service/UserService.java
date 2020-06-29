package com.melcoc.bluewhale.service;

import com.melcoc.bluewhale.domain.LUser;
import com.melcoc.bluewhale.domain.LUserrole;
import com.melcoc.bluewhale.domain.User;

import java.util.concurrent.Future;

public interface UserService {
    //登录查询
    Future<LUser> getUserWithPermission(String account);
    //注册-用户名/邮箱地址重复查询
    Future<Boolean> getUserNameNoRepeat(String username);
    Future<Boolean> getUserEmailNoRepeat(String email);

    //注册
    Future<Boolean> register(User userBean, LUser lUserBean);

    //修改密码
    Future<Boolean> changePassword(LUser lUser);

    Future<User> selectUserByName(String username);

    Future<LUser> selectlUserByName(String username);

    Future<Boolean> insertUserrole(LUserrole lUserrole);



    /**
     * 根据UserId修改avatar
     * @return
     */

    Future<Boolean> updateById(User user);
    //上传头像
    Future<Boolean> updateByIduUrl(String name, String avatar);

    Future<Integer> selectUserId(String name);

}
