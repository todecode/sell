package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @className: ProductCategory
 * @description: 类目
 * @author: cyd
 * @date: 2020/7/15 下午10:07
 **/
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    /**类目id**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目类别
     */
    private Integer categoryType;

    public ProductCategory(){}

    public ProductCategory(String categoryName,Integer categoryType){
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    /**创建时间**/
    private Date createTime;
//
//    /**更新时间**/
//    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
}
