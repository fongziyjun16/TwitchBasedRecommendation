package com.cyj.tbr.service;

import com.cyj.tbr.dao.FavoriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteDao favoriteDao;

}
