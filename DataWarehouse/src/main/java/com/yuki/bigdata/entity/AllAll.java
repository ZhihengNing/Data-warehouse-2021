package com.yuki.bigdata.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 
 * @TableName all_all
 */
@TableName(value ="all_all")
@Data
public class AllAll implements Serializable {
    /**
     * 人员1
     */
    private String crew1;

    /**
     * 人员2
     */
    private String crew2;

    /**
     * 电影数组
     */
    private String asin;

    /**
     * 关系
     */
    private String cooperation;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}