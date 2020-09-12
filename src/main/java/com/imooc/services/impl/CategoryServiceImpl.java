package com.imooc.services.impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.repository.ProductCategoryRepository;
import com.imooc.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: CategoryServiceImpl
 * @description:
 * @author: cyd
 * @date: 2020/8/31 下午10:14
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    protected ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return this.repository.getOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeIds) {
        return this.repository.findByCategoryTypeIn(categoryTypeIds);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return this.repository.save(productCategory);
    }
}
