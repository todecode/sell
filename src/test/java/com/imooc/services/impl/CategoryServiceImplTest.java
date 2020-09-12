package com.imooc.services.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Test
    public void findOne() {
        ProductCategory result = this.categoryServiceImpl.findOne(1);
        Assert.assertEquals(new Integer(1),result.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> result = this.categoryServiceImpl.findAll();
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> ids = Arrays.asList(2,3,4);
        List<ProductCategory> result = this.categoryServiceImpl.findByCategoryTypeIn(ids);
        Assert.assertNotNull(result);
    }

    @Test
    @Transactional
    public void save() {
        ProductCategory param = new ProductCategory("测试",3);
        ProductCategory result = this.categoryServiceImpl.save(param);
        Assert.assertNotNull(result);
    }
}
