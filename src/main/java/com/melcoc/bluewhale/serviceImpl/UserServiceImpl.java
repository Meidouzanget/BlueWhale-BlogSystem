package com.melcoc.bluewhale.serviceImpl;

import com.melcoc.bluewhale.dao.LUserDao;
import com.melcoc.bluewhale.dao.LUserroleDao;
import com.melcoc.bluewhale.dao.UserDao;
import com.melcoc.bluewhale.domain.LUser;
import com.melcoc.bluewhale.domain.LUserrole;
import com.melcoc.bluewhale.domain.User;
import com.melcoc.bluewhale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@SuppressWarnings("ALL")
@Async("taskExecutor")
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private LUserDao dao;

    @Autowired
    private UserDao controllDao;

    @Autowired
    private LUserroleDao lUserroleDao;


    @Override
    public Future<LUser> getUserWithPermission(String account)
    {
        return new AsyncResult<>(dao.getUserWithPermission(account));
    }

    //查询用户名是否重复

    @Override
    public Future<Boolean> getUserNameNoRepeat(String username) {
        if (controllDao.RepeatUserNameQuery(username) == 0){
            return new AsyncResult<>( true);
        }else {
            return new AsyncResult<>( false);
        }
    }

    //查询用户邮箱是否重复

    @Override
    public Future<Boolean> getUserEmailNoRepeat(String email) {
        if (controllDao.RepeatUserEmailQuery(email) == 0){
            return new AsyncResult<>( true);
        }else {
            return new AsyncResult<>( false);
        }
    }

    //注册

    @Override
    public Future<Boolean> register(User userBean, LUser lUserBean) {
        if (controllDao.insert(userBean)==1 && dao.insert(lUserBean)==1){
            return new AsyncResult<>( true);
        }else {
            return new AsyncResult<>( false);
        }
    }


    @Override
    public Future<Boolean> changePassword(LUser lUser) {
        if (dao.updateById(lUser) == 1){
            return new AsyncResult<>( true);
        }else {
            return new AsyncResult<>( false);
        }
    }


    @Override
    public Future<User> selectUserByName(String username) {
        return new AsyncResult<>( controllDao.selectByUserName(username));
    }


    @Override
    public Future<LUser> selectlUserByName(String username) {
        return new AsyncResult<>( controllDao.selectBylUserName(username));
    }


    @Override
    public Future<Boolean> insertUserrole(LUserrole lUserrole) {
        if (lUserroleDao.insert(lUserrole)==1){
            return new AsyncResult<>( true);
        }else {
            return new AsyncResult<>( false);
        }
    }


    @Override
    public Future<Boolean> updateById(User user) {
        if (controllDao.updateById(user) == 1){
            return new AsyncResult<>( true);
        }else {
            return new AsyncResult<>( false);
        }
    }



    @Override
    public Future<Boolean> updateByIduUrl(String name, String avatar) {
        if (controllDao.updateByIduUrl(name,avatar)==1){
            return new AsyncResult<>( true);
        }else{
            return new AsyncResult<>( false);
        }

    }


    @Override
    public Future<Integer> selectUserId(String name) {
        return new AsyncResult<>( controllDao.selectUserId(name));
    }


}
