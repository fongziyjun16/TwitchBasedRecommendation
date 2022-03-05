package com.cyj.tbr.service;

import com.cyj.tbr.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public String verifyLogin(String userId, String password) {
        return loginDao.verifyLogin(userId, password);
    }

}
