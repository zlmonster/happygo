package com.happygo.manage.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.happygo.common.bean.EasyUIResult;
import com.happygo.manage.mapper.ItemMapper;
import com.happygo.manage.pojo.Item;
import com.happygo.manage.pojo.ItemDesc;
import com.happygo.manage.pojo.ItemParamItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemService extends BaseService<Item> {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemDescService itemDescService;

    @Autowired
    private ItemParamItemService itemParamItemService;

    @Value("${HAPPYGO_WEB_URL}")
    private String HAPPYGO_WEB_URL;

//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public Boolean saveItem(Item item, String desc, String itemParams) {
        // 初始值
        item.setStatus(1);
        item.setId(null); // 出于安全考虑，强制设置id为null，通过数据库自增长得到
        Integer count1 = super.save(item);

        // 保存商品描述数据
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        Integer count2 = this.itemDescService.save(itemDesc);

        // 保存规格参数数据
        ItemParamItem itemParamItem = new ItemParamItem();
        itemParamItem.setItemId(item.getId());
        itemParamItem.setParamData(itemParams);
        Integer count3 = this.itemParamItemService.save(itemParamItem);

        //发送消息到MQ的交换机，通知其他系统
//        sendMsg(item.getId(), "insert");

        return count1.intValue() == 1 && count2.intValue() == 1 && count3.intValue() == 1;

    }
//    public Boolean deleteItem(String ids) {
//        String[] idString = ids.split(",");
//        Long[] idLong = new Long[idString.length];
//        for (int i = 0; i < idString.length; i++) {
//            idLong[i] = Long.parseLong(idString[i]);
//        }
//
//        List<Object> idList = (List<Object>)Arrays.asList(idLong);
//        // 初始值
//        item.setStatus(1);
//        item.setId(null); // 出于安全考虑，强制设置id为null，通过数据库自增长得到
//        Integer count1 = super.save(item);
//        Example example = new Example(Item.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andIn("id", idList);
//
//        deleteById(id)
//
//        // 保存商品描述数据
//        ItemDesc itemDesc = new ItemDesc();
//        itemDesc.setItemId(item.getId());
//        itemDesc.setItemDesc(desc);
//        Integer count2 = this.itemDescService.save(itemDesc);
//
//        // 保存规格参数数据
//        ItemParamItem itemParamItem = new ItemParamItem();
//        itemParamItem.setItemId(item.getId());
//        itemParamItem.setParamData(itemParams);
//        Integer count3 = this.itemParamItemService.save(itemParamItem);
//
//        //发送消息到MQ的交换机，通知其他系统
////        sendMsg(item.getId(), "insert");
//
//        return count1.intValue() == 1 && count2.intValue() == 1 && count3.intValue() == 1;
//
//    }

    public EasyUIResult queryItemList(Integer page, Integer rows) {

        // 设置分页参数
        PageHelper.startPage(page, rows);

        Example example = new Example(Item.class);
        // 安装创建时间排序
        example.setOrderByClause("created DESC");
        List<Item> items = this.itemMapper.selectByExample(example);

        PageInfo<Item> pageInfo = new PageInfo<Item>(items);

        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }

    public Boolean updateItem(Item item, String desc, String itemParams) {
        item.setStatus(null);// 强制设置状态不能被修改
        Integer count1 = super.updateSelective(item);

        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        Integer count2 = this.itemDescService.updateSelective(itemDesc);

        // 更新规格参数数据
        Integer count3 = this.itemParamItemService.updateItemParamItem(item.getId(), itemParams);

//        try {
//            // 通知其他系统该商品已经更新
//            String url = TAOTAO_WEB_URL + "/item/cache/" + item.getId() + ".html";
//            this.apiService.doPost(url);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //发送消息到MQ的交换机，通知其他系统
//        sendMsg(item.getId(), "update");

        return count1.intValue() == 1 && count2.intValue() == 1 && count3.intValue() == 1;
    }

//    private void sendMsg(Long itemId, String type){
//        try {
//            //发送消息到MQ的交换机，通知其他系统
//            Map<String, Object> msg = new HashMap<String, Object>();
//            msg.put("itemId", itemId);
//            msg.put("type", type);
//            msg.put("date", System.currentTimeMillis());
//            this.rabbitTemplate.convertAndSend("item." + type, MAPPER.writeValueAsString(msg));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
