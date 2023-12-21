package com.yuki.bigdata.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName role
 */
@TableName(value ="role")
@Data
public class Role implements Serializable {
    /**
     * ????
     */
    private String name;

    /**
     * ??Id
     */
    private String asin;

    /**
     * ????
     */
    private String role;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}