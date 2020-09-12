package com.imooc.services.impl;

import com.imooc.config.SellException;
import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @className: ProductServiceImpl
 * @description:
 * @author: cyd
 * @date: 2020/8/31 下午11:01
 **/
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(productId);

        Example<ProductInfo> example = Example.of(productInfo);
        Optional<ProductInfo> productOptional = this.repository.findOne(example);
        if (!productOptional.isPresent()) {
            log.error("【查询】商品id={}不存在",productId);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        return productOptional.get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return this.repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return this.repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOS) {
        for(CartDTO cartDTO : cartDTOS) {
            ProductInfo productInfo = repository.getOne(cartDTO.getProductId());
            if(productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOS) {
        for(CartDTO cartDTO : cartDTOS) {
            ProductInfo productInfo = repository.getOne(cartDTO.getProductId());
            if(productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            // TODO: 2020/9/3 待优化，后面会增加redis锁机制做处理
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStatus(result);
            repository.save(productInfo);
        }
    }
}
