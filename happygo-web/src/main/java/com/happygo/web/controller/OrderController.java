//package com.happygo.web.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.happygo.web.bean.Cart;
//import com.happygo.web.bean.Item;
//import com.happygo.web.bean.Order;
//import org.apache.commons.lang3.StringUtils;
//import org.joda.time.DateTime;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.happygo.web.service.CartService;
//import com.happygo.web.service.ItemService;
//import com.happygo.web.service.OrderService;
//
//@RequestMapping("order")
//@Controller
//public class OrderController {
//
//    @Autowired
//    private ItemService itemService;
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private CartService cartService;
//
//    /**
//     * 订单确认页
//     *
//     * @param itemId
//     * @return
//     */
//    @RequestMapping(value = "{itemId}", method = RequestMethod.GET)
//    public ModelAndView toOrder(@PathVariable("itemId") Long itemId) {
//        ModelAndView mv = new ModelAndView("order");
//        Item item = this.itemService.queryById(itemId);
//        mv.addObject("item", item);
//        return mv;
//    }
//
//    /**
//     * 基于购物车下单（购物车中全部商品下单）
//     *
//     * @return
//     */
//    @RequestMapping(value = "create", method = RequestMethod.GET)
//    public ModelAndView toCartOrder() {
//        ModelAndView mv = new ModelAndView("order-cart");
//        List<Cart> carts = this.cartService.queryCartList();
//        mv.addObject("carts", carts);
//        return mv;
//    }
//
//    /**
//     * 提交订单
//     *
//     * @param order
//     * @return
//     */
//    @RequestMapping(value = "submit", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> submit(Order order) {
//        Map<String, Object> result = new HashMap<String, Object>();
//
//        String orderId = this.orderService.submit(order);
//        if (StringUtils.isEmpty(orderId)) {
//            // 订单提交失败
//            result.put("status", 500);
//        } else {
//            // 订单提交成功
//            result.put("status", 200);
//            result.put("data", orderId);
//        }
//        return result;
//    }
//
//    @RequestMapping(value = "success", method = RequestMethod.GET)
//    public ModelAndView success(@RequestParam("id") String orderId) {
//        ModelAndView mv = new ModelAndView("success");
//        // 订单数据
//        Order order = this.orderService.queryByOrderId(orderId);
//        mv.addObject("order", order);
//        // 送货时间，当前时间向后推2天,格式：08月18日
//        mv.addObject("date", new DateTime().plusDays(2).toString("MM月dd日"));
//        return mv;
//    }
//
//}
