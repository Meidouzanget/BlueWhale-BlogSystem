package com.melcoc.bluewhale.serviceImpl;

import com.melcoc.bluewhale.dao.LUserDao;
import com.melcoc.bluewhale.dao.LUserroleDao;
import com.melcoc.bluewhale.dao.UserDao;
import com.melcoc.bluewhale.domain.LUser;
import com.melcoc.bluewhale.domain.LUserrole;
import com.melcoc.bluewhale.domain.User;
import com.melcoc.bluewhale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private LUserDao dao;

    @Autowired
    private UserDao controllDao;

    @Autowired
    private LUserroleDao lUserroleDao;

    public LUser getUserWithPermission(String account)
    {
        return dao.getUserWithPermission(account);
    }

    //查询用户名是否重复
    public boolean getUserNameNoRepeat(String username) {
        if (controllDao.RepeatUserNameQuery(username) == 0){
            return true;
        }else {
        return false;
        }
    }

    //查询用户邮箱是否重复
    public boolean getUserEmailNoRepeat(String email) {
        if (controllDao.RepeatUserEmailQuery(email) == 0){
            return true;
        }else {
            return false;
        }
    }

    //注册
    @Override
    public boolean register(User userBean, LUser lUserBean) {
        if (controllDao.insert(userBean)==1 && dao.insert(lUserBean)==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean changePassword(LUser lUser) {
        if (dao.updateById(lUser) == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User selectUserByName(String username) {
        return controllDao.selectByUserName(username);
    }

    @Override
    public LUser selectlUserByName(String username) {
        return controllDao.selectBylUserName(username);
    }

    @Override
    public boolean insertUserrole(LUserrole lUserrole) {
        if (lUserroleDao.insert(lUserrole)==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateById(User user) {
        if (controllDao.updateById(user) == 1){
            return true;
        }else {
            return false;
        }
    }


    @Override
    public boolean updateByIduUrl(int userId, String avatar) {
        if (controllDao.updateByIduUrl(userId,avatar)==1){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public int selectUserId(String name) {
        return controllDao.selectUserId(name);
    }


}
