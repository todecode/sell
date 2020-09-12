package com.imooc.services;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * @className: CategoryService
 * @description:
 * @author: cyd
 * @date: 2020/8/31 下午10:12
 **/
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeIds);

    ProductCategory save(ProductCategory productCategory);
}
