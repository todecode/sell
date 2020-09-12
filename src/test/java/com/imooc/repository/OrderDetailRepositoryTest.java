package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private  OrderDetailRepository repository;
    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("2");
        orderDetail.setOrderId("332");
        orderDetail.setProductIcon("11111.jpg");
        orderDetail.setProductId("22");
        orderDetail.setProductPrice(new BigDecimal("7.0"));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductName("小鸡腿");
        repository.save(orderDetail);
        Assert.assertNotNull(orderDetail);
    }
    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId("2");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}
