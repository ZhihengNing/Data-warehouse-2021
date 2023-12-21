package com.yuki.bigdata.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName crew
 */
@TableName(value ="crew")
@Data
public class Crew implements Serializable {
    /**
     * ????
     */
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}