package com.yuki.bigdata.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName review
 */
@TableName(value ="review")
@Data
public class Review implements Serializable {
    /**
     * ??Id
     */
    private String asin;

    /**
     * ??id
     */
    private String userId;

    /**
     * ????
     */
    private Integer rating;

    /**
     * ????
     */
    private String reviewSum;

    /**
     * ????
     */
    private Date reviewDate;

    /**
     * ????????
     */
    private Integer helpfulness;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}