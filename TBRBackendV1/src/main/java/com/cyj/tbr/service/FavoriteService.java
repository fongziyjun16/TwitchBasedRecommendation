package com.cyj.tbr.service;

import com.cyj.tbr.dao.FavoriteDao;
import com.cyj.tbr.entity.db.Item;
import com.cyj.tbr.entity.db.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteDao favoriteDao;

    public void setFavoriteItem(String userId, Item item) {
        favoriteDao.setFavoriteItem(userId, item);
    }

    public void unsetFavoriteItem(String userId, Item item) {
        favoriteDao.unsetFavoriteItem(userId, item);
    }

    public Map<String, List<Item>> getFavoriteItems(String userId) {
        Map<String, List<Item>> itemMap = new HashMap<>();
        for (ItemType itemType : ItemType.values()) {
            itemMap.put(itemType.toString(), new ArrayList<>());
        }
        Set<Item> favoriteItems = favoriteDao.getFavoriteItems(userId);
        for (Item item : favoriteItems) {
            itemMap.get(item.getType().toString()).add(item);
        }
        return itemMap;
    }

}
