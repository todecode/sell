package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
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
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void save(){
        ProductInfo info = new ProductInfo();
        info.setProductId("123456");
        info.setProductName("皮蛋粥");
        info.setProductPrice(BigDecimal.valueOf(3.2));
        info.setProductStock(100);
        info.setProductDescription("很好喝的粥");
        info.setProductIcon("http://xxx.com.jpg");
        info.setProductStatus(0);
        info.setCategoryType(2);
        this.repository.save(info);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> result = this.repository.findByProductStatus(0);
        Assert.assertNotNull(result);
    }
}
