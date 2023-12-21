package com.yuki.bigdata.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName users
 */
@TableName(value ="users")
@Data
public class Users implements Serializable {
    /**
     * ??Id
     */
    private String id;

    /**
     * ????
     */
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}