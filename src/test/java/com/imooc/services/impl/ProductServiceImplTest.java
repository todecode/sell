package com.imooc.services.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo result = this.productService.findOne("123456");
        Assert.assertEquals("123456",result.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = this.productService.findUpAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findAll() {
        PageRequest pageable = PageRequest.of(0,10);
        Page<ProductInfo> result = this.productService.findAll(pageable);
//        System.out.println(result.getTotalPages());
        Assert.assertNotEquals(0,result.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo info = new ProductInfo();
        info.setProductId("123457");
        info.setProductName("蛋挞");
        info.setProductPrice(BigDecimal.valueOf(3.2));
        info.setProductStock(100);
        info.setProductDescription("很好吃的蛋挞");
        info.setProductIcon("http://xxx.com.jpg");
        info.setProductStatus(ProductStatusEnum.DOWN.getCode());
        info.setCategoryType(2);
        ProductInfo result = this.productService.save(info);
        Assert.assertNotNull(result);
    }
}
