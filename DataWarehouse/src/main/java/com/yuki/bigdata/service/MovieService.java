package com.yuki.bigdata.service;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;

public interface MovieService {
    int getCountByYear(int year);

    int getCountByYearMonth(int year,int month);

    int getCountByYearSeason(int year,String season);

    int getCountByDay(String date);

    int getCountByOtherFormat(String asin);

    int getCountMovieOfDirector(String director);

    int getCountMovieOfActor(String actor);

    JSONObject getCountCooperationActor(String crew);

    JSONObject getCountCooperationDirector(String crew);

    int getCountByMovieStyle(String style);

    int getCountByScore(BigDecimal score);

    int getCountByComment(double x);


    String getMaxCooperationByActorYear(String actorName,int year);

    int getCountByActorYear(String actorName,int year);


    int getCountByyearStyle(int year,String style);

    JSONObject getCooperationMax();




}
