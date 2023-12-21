package com.yuki.bigdata.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 
 * @TableName movie
 */
@TableName(value ="movie")
@Data
public class Movie implements Serializable {
    /**
     * ??Id
     */
    private String asin;

    /**
     * ????
     */
    private String title;

    /**
     * ????
     */
    private BigDecimal starRating;

    /**
     * ????
     */
    private String production;

    /**
     * ????
     */
    private String runTime;

    /**
     * ????
     */
    private Date releaseDay;

    /**
     * ????
     */
    private Integer releaseYear;

    /**
     * ????
     */
    private Integer releaseMonth;

    /**
     * ????
     */
    private String releaseSeason;

    /**
     * ????
     */
    private String style;

    /**
     * ??
     */
    private String directors;

    /**
     * ??
     */
    private String actors;

    /**
     * 
     */
    private String additionalOption;

    /**
     * ????
     */
    private String otherFormat;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}