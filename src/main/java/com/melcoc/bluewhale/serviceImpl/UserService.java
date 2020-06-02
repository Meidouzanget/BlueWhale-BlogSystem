package com.melcoc.bluewhale.serviceImpl;

import com.melcoc.bluewhale.dao.UserDao;
import com.melcoc.bluewhale.domain.LUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class UserService
{
    @Autowired
    private UserDao dao;

    public LUser getUserWithPermission(String account)
    {
        return dao.getUserWithPermission(account);
    }
}
