//package com.happygo.web.service;
//
//import com.happygo.common.httpclient.HttpResult;
//import com.happygo.common.service.ApiService;
//import com.happygo.web.bean.Order;
//import com.happygo.web.threadlocal.UserThreadLocal;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.happygo.common.httpclient.HttpResult;
//import com.happygo.common.service.ApiService;
//import com.happygo.sso.query.bean.User;
//
//@Service
//public class OrderService {
//
//    @Autowired
//    private ApiService apiService;
//
//    @Value("${HAPPYGO_ORDER_URL}")
//    private String HAPPYGO_ORDER_URL;
//
//    private static final ObjectMapper MAPPER = new ObjectMapper();
//
//    /**
//     * 提交订单到订单系统
//     *
//     * @param order
//     * @return
//     */
//    public String submit(Order order) {
//        String url = HAPPYGO_ORDER_URL + "/order/create";
//
//        // 填充当前登录用户的信息
//        User user = UserThreadLocal.get();
//        order.setUserId(user.getId());
//        order.setBuyerNick(user.getUsername());
//
//        try {
//            String json = MAPPER.writeValueAsString(order);
//            HttpResult httpResult = this.apiService.doPostJson(url, json);
//            if (httpResult.getCode().intValue() == 200) {
//                String body = httpResult.getBody();
//                JsonNode jsonNode = MAPPER.readTree(body);
//                if (jsonNode.get("status").asInt() == 200) {
//                    // 提交成功
//                    return jsonNode.get("data").asText();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public Order queryByOrderId(String orderId) {
//        String url = HAPPYGO_ORDER_URL + "/order/query/" + orderId;
//        try {
//            String jsonData = this.apiService.doGet(url);
//            if (StringUtils.isNotEmpty(jsonData)) {
//                return MAPPER.readValue(jsonData, Order.class);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}
