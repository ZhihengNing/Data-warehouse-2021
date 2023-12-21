package com.yuki.bigdata.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuki.bigdata.common.util.StringUtil;
import com.yuki.bigdata.entity.Movie;
import com.yuki.bigdata.entity.Review;
import com.yuki.bigdata.entity.Role;
import com.yuki.bigdata.mapper.AllAllMapper;
import com.yuki.bigdata.mapper.MovieMapper;
import com.yuki.bigdata.mapper.ReviewMapper;
import com.yuki.bigdata.mapper.RoleMapper;
import com.yuki.bigdata.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieMapper movieMapper;

    private RoleMapper roleMapper;

    private ReviewMapper reviewMapper;

    private AllAllMapper allAllMapper;

    @Autowired
    public void setMovieMapper(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Autowired
    public void setReviewMapper(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    @Autowired
    public void setAllAllMapper(AllAllMapper allAllMapper){
        this.allAllMapper=allAllMapper;
    }

    @Override
    public int getCountByYear(int year) {
        return movieMapper.getCountByYear(year);
    }

    @Override
    public int getCountByYearMonth(int year, int month) {
        return movieMapper.getCountByYearMonth(year,month);
    }

    @Override
    public int getCountByYearSeason(int year, String season) {
        return movieMapper.getCountByYearSeason(year,season);
    }

    @Override
    public int getCountByDay(String date) {
        return movieMapper.getCountByDay(date);
    }

    @Override
    public int getCountByOtherFormat(String asin) {
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", asin);
        Movie movie = movieMapper.selectOne(queryWrapper);
        if(movie==null)
            return 0;
        List<String> transfer =
                StringUtil.transfer(movie.getOtherFormat());
        return transfer.size();
    }

    @Override
    public int getCountMovieOfDirector(String director) {
        QueryWrapper<Role>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",director).eq("role","director");
        return roleMapper.selectList(queryWrapper).size();
    }

    @Override
    public int getCountMovieOfActor(String actor) {
        QueryWrapper<Role>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",actor).eq("role","actor");
        return roleMapper.selectList(queryWrapper).size();
    }

    @Override
    public JSONObject getCountCooperationActor(String crew) {
        Optional<JSONObject> times = allAllMapper.getCountCooperationActor(crew).stream()
                .max(Comparator.comparingInt(s -> s.getJSONObject("_u1").getIntValue("times")));
        return times.map(jsonObject -> jsonObject.getJSONObject("_u1")).orElse(null);
    }

    @Override
    public JSONObject getCountCooperationDirector(String crew) {
        Optional<JSONObject> times = allAllMapper.getCountCooperationDirector(crew).stream()
                .max(Comparator.comparingInt(s -> s.getJSONObject("_u1").getIntValue("times")));
        return times.map(jsonObject -> jsonObject.getJSONObject("_u1")).orElse(null);
    }

    @Override
    public int getCountByMovieStyle(String style) {
        QueryWrapper<Movie>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("style",style);
        return movieMapper.selectCount(queryWrapper);
    }

    @Override
    public int getCountByScore(BigDecimal score) {
        QueryWrapper<Movie>queryWrapper=new QueryWrapper<>();
        queryWrapper.gt("star_rating",score.doubleValue());
        return movieMapper.selectCount(queryWrapper);
    }

    @Override
    public int getCountByComment(double x) {
        QueryWrapper<Review>queryWrapper=new QueryWrapper<>();
        queryWrapper.select("distinct asin").gt("rating",x);
        return reviewMapper.selectCount(queryWrapper);
    }

    @Override
    public String getMaxCooperationByActorYear(String actorName, int year) {

        return null;
    }

    @Override
    public int getCountByActorYear(String actorName, int year) {
        return movieMapper.getCountByActorYear(actorName,year);
    }

    @Override
    public int getCountByyearStyle(int year, String style) {
        QueryWrapper<Movie>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("release_year",year).eq("style",style);
        return movieMapper.selectCount(queryWrapper);
    }

    @Override
    public JSONObject getCooperationMax() {
        return movieMapper.getCooperationMax();
    }


}
