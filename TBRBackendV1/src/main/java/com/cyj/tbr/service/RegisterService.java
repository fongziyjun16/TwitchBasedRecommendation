package com.cyj.tbr.service;

import com.cyj.tbr.dao.RegisterDao;
import com.cyj.tbr.entity.db.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RegisterService {

    @Autowired
    private RegisterDao registerDao;

    public boolean register(User user) throws IOException {
        return registerDao.register(user);
    }


}
