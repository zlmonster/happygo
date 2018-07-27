//package com.happygo.web.service;
//
//import java.util.List;
//
//import com.happygo.common.service.ApiService;
//import com.happygo.web.bean.Cart;
//import com.happygo.web.threadlocal.UserThreadLocal;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.happygo.sso.query.bean.User;
//
//@Service
//public class CartService {
//
//    @Autowired
//    private ApiService apiService;
//
//    @Value("${HAPPYGO_CART_URL}")
//    private String HAPPYGO_CART_URL;
//
//    private static final ObjectMapper MAPPER = new ObjectMapper();
//
//    public List<Cart> queryCartList() {
//        try {
//            User user = UserThreadLocal.get();
//            String url = HAPPYGO_CART_URL + "/service/api/cart/" + user.getId();
//            String jsonData = this.apiService.doGet(url);
//            if (StringUtils.isNotEmpty(jsonData)) {
//                return MAPPER.readValue(jsonData,
//                        MAPPER.getTypeFactory().constructCollectionType(List.class, Cart.class));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}
