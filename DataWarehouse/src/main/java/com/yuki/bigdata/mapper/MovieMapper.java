package com.yuki.bigdata.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuki.bigdata.entity.Movie;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
* @author 86180
* @description 针对表【movie】的数据库操作Mapper
* @createDate 2021-12-25 15:10:49
* @Entity com.yuki.bigdata.entity.Movie
*/
@Repository
public interface MovieMapper extends BaseMapper<Movie> {

    int getCountByYear(@Param("year") int year);

    int getCountByYearMonth(@Param("year")int year,@Param("month")int month);

    int getCountByYearSeason(@Param("year")int year,@Param("season")String season);

    int getCountByDay(@Param("date")String date);

    int getCountByActorYear(@Param("name")String actorName,@Param("year")int year);

    JSONObject getCooperationMax();




}




