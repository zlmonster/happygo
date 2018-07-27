//package com.happygo.web.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.happygo.sso.query.api.UserQueryService;
//import com.happygo.sso.query.bean.User;
//
//@Service
//public class UserService {
//
////    @Autowired
////    private ApiService apiService;
//
//    @Value("${HAPPYGO_SSO_URL}")
//    public String HAPPYGO_SSO_URL;
//
////    private static final ObjectMapper MAPPER = new ObjectMapper();
//
//    @Autowired
//    private UserQueryService userQueryService;
//
//    /**
//     * 根据token查询用户信息
//     *
//     * @param token
//     * @return
//     */
//    public User queryByToken(String token) {
//        return this.userQueryService.queryUserByToken(token);
//    }
//
////    public User queryByToken(String token) {
////        try {
////            String url = HAPPYGO_SSO_URL + "/service/user/" + token;
////            String jsonData = this.apiService.doGet(url);
////            if (StringUtils.isNotEmpty(jsonData)) {
////                return MAPPER.readValue(jsonData, User.class);
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return null;
////    }
//
//}
