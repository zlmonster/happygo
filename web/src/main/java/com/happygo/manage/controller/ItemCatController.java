package com.happygo.manage.controller;

import com.happygo.manage.pojo.ItemCat;
import com.happygo.manage.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author <a href="mailto:wb-lzl282164@alibaba-inc.com">李智龙</a>
 * @since 2018/7/16
 */
@RequestMapping("item/cat")
@Controller
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<List<ItemCat>> queryItemCatList(
            @RequestParam(value = "id", defaultValue = "0")Long parentId) {

        try {
            List<ItemCat> itemCatList = itemCatService.queryItemCatList(parentId);
            if (CollectionUtils.isEmpty(itemCatList)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(itemCatList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
