package com.happygo.manage.service;

import com.happygo.manage.mapper.ItemCatMapper;
import com.happygo.manage.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author <a href="mailto:wb-lzl282164@alibaba-inc.com">李智龙</a>
 * @since 2018/7/16
 */
@Service
public class ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    public List<ItemCat> queryItemCatList(Long parentId) {
        ItemCat itemCat = new ItemCat();
        itemCat.setParentId(parentId);
        return itemCatMapper.select(itemCat);
    }
}
