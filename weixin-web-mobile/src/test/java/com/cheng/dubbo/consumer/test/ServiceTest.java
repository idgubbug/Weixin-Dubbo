package com.cheng.dubbo.consumer.test;

import com.alibaba.fastjson.JSON;
import com.cheng.weixin.web.mobile.result.cart.ProductCartInfo;
import com.cheng.weixin.web.mobile.result.index.Index;
import com.cheng.weixin.web.mobile.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;

/**
 * Desc:
 * Author: hp
 * Date: 2016/10/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-dubbo-consumer.xml",
        "classpath*:applicationContext.xml"})
public class ServiceTest {
    @Autowired
    private SysIndexService indexService;
    @Autowired
    private SysOrderService orderService;
    @Autowired
    private SysProductService productService;
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysMallService mallService;
    @Autowired
    private SysCartService cartService;

    // ===========================ORDER============================== //
    @Test
    public void test01() {
        Index index = indexService.getIndexInfo();
        System.out.println(JSON.toJSONString(index));
    }

    //@Test
    //public void test02() {
    //    SubmitOrderInfo info = orderService.payment();
    //    System.out.println(JSON.toJSONString(info));
    //}
    //@Test
    //public void test03() {
    //    orderService.submitOrder();
    //}
    @Test
    public void test04() throws InvocationTargetException, IllegalAccessException {
        System.out.println(orderService.getOrders(1, 10));
    }
    @Test
    public void test05() {
        System.out.println(orderService.getOrderDetail());
    }

    // ===========================PRODUCT============================== //
    @Test
    public void test06() {
        System.out.println(productService.getDetail("1"));
    }
    @Test
    public void test07() {
        productService.buyProduct("1", 2L);
    }
    @Test
    public void test08() {
        System.out.println(productService.focus("1"));
    }

    // ==========================USER=============================== //
    @Test
    public void test09() {
        System.out.println(userService.getUserDetail());
    }

    @Test
    public void test091() {
        System.out.println(userService.getDeliveryAddrs());
    }

    // ==========================MALL=============================== //
    @Test
    public void test10() {
        System.out.println(mallService.getProductCategory());
    }
    @Test
    public void test11() {
        System.out.println(mallService.getMallProduct("1"));
    }

    // ==========================CART=============================== //
   /* @Test
    public void test12() {
        System.out.println(cartService.getShoppingCart());
    }*/
    @Test
    public void test13() {
        System.out.println(cartService.addProduct("1"));
    }
    @Test
    public void test14() {
        System.out.println(cartService.subProduct("1"));
    }
    @Test
    public void test15() {
        System.out.println(cartService.deleteProduct("1"));
    }
    @Test
    public void test16() {
        cartService.changeStatus("1");
    }

    @Test
    public void test17() {
        cartService.chooseAllProduct();
    }

    @Test
    public void test18() {
        cartService.unChooseAllProduct();
    }
    @Test
    public void test19() {
        ProductCartInfo productCartInfo = cartService.changeStatus("1");
        System.out.println(productCartInfo);
    }
}
