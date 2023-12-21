package com.yuki.bigdata.controller;

import com.alibaba.fastjson.JSONObject;
import com.yuki.bigdata.common.result.CommonResult;
import com.yuki.bigdata.service.MovieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@RequestMapping("/movie")
@RestController
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/demo1", method = RequestMethod.GET)
    public void test1() {
        System.out.println(233);
    }

    @ApiOperation("1.某一年有多少电影")
    @RequestMapping(value = "/year", method = RequestMethod.GET)
    public CommonResult<Integer> getCountByYear(@RequestParam("year") int year) {
        long begin = Calendar.getInstance().getTime().getTime();
        int countByYear = movieService.getCountByYear(year);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success(end - begin, countByYear);
    }

    @ApiOperation("2.某一年某一个月有多少电影")
    @RequestMapping(value = "/yearMonth", method = RequestMethod.GET)
    public CommonResult<Integer> getCountByYearMonth(@RequestParam("year") int year,
                                                     @RequestParam("month") int month) {
        long begin = Calendar.getInstance().getTime().getTime();
        int countByYearMonth = movieService.getCountByYearMonth(year, month);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success(end - begin, countByYearMonth);
    }

    @ApiOperation("3.某一天有多少电影")
    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public CommonResult<Integer> getCountByday(@RequestParam("date")String date) {
        long begin = Calendar.getInstance().getTime().getTime();
        int countByYearMonth = movieService.getCountByDay(date);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success(end - begin, countByYearMonth);
    }

    @ApiOperation("4.某一年某一个季度有多少电影")
    @RequestMapping(value = "/yearSeason", method = RequestMethod.GET)
    public CommonResult<Integer> getCountByYearSeason(@RequestParam("year")int year,
                                                      @RequestParam("season")String season) {
        if(season.equals("1")){
            season="spring";
        }else if(season.equals("2")){
            season="summer";
        }else if(season.equals("3")){
            season="fall";
        }else{
            season="winter";
        }
        long begin = Calendar.getInstance().getTime().getTime();
        int countByYearMonth = movieService.getCountByYearSeason(year,season);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success(end - begin, countByYearMonth);
    }

    @ApiOperation("5.某一电影有多少版本")
    @RequestMapping(value = "/otherFormat",method = RequestMethod.GET)
    public CommonResult<Integer> getOtherFormat(@RequestParam("title")String asin){
        long begin = Calendar.getInstance().getTime().getTime();

        int countByOtherFormat = movieService.getCountByOtherFormat(asin);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success(end-begin,countByOtherFormat==0?0:countByOtherFormat+1);
    }

    @ApiOperation("6.某一导演指导多少电影")
    @RequestMapping(value = "/director",method = RequestMethod.GET)
    public CommonResult<Integer> getMovieNumByDirector(@RequestParam("director")String director){
        long begin = Calendar.getInstance().getTime().getTime();
        int countMovieOfDirector = movieService.getCountMovieOfDirector(director);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success(end-begin,countMovieOfDirector);
    }

    @ApiOperation("7.某一演员参与多少电影")
    @RequestMapping(value = "/actor",method = RequestMethod.GET)
    public CommonResult<Integer> getMovieNumByActor(@RequestParam("actor")String actor){
        long begin = Calendar.getInstance().getTime().getTime();
        int countMovieOfActor = movieService.getCountMovieOfActor(actor);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success(end-begin,countMovieOfActor);
    }

    @ApiOperation("8.按人名名称查询合作最多的演员和合作次数")
    @RequestMapping(value = "/cooperationActor",method = RequestMethod.GET)
    public CommonResult<JSONObject>getcooperationActor(@RequestParam("crew") String crew){
        long begin = Calendar.getInstance().getTime().getTime();
        JSONObject countCooperationActor = movieService.getCountCooperationActor(crew);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success(end-begin,countCooperationActor);
    }

    @ApiOperation("9.按人名名称查询合作最多的导演和合作次数")
    @RequestMapping(value = "/cooperationDirector",method = RequestMethod.GET)
    public CommonResult<JSONObject>getcooperationDirector(@RequestParam("crew") String crew){
        long begin = Calendar.getInstance().getTime().getTime();
        JSONObject countCooperationDirector = movieService.getCountCooperationDirector(crew);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success(end-begin,countCooperationDirector);
    }

    @ApiOperation("10.按照电影类别查询电影总数")
    @RequestMapping(value = "/style",method = RequestMethod.GET)
    public CommonResult<Integer>getMovieNumByStyle(@RequestParam("style") String style){
        long begin = Calendar.getInstance().getTime().getTime();
        int countByMovieStyle = movieService.getCountByMovieStyle(style);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success(end-begin,countByMovieStyle);
    }


    @ApiOperation("11.查询评分在x以上的电影数")
    @RequestMapping(value = "/score",method = RequestMethod.GET)
    public CommonResult<Integer>getMovieNumByScore(@RequestParam("score") BigDecimal score){
        long begin = Calendar.getInstance().getTime().getTime();
        int countByScore = movieService.getCountByScore(score);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success(end-begin,countByScore);
    }


    @ApiOperation("12.查询存在评分大于3的评论的电影数")
    @RequestMapping(value = "/comment",method = RequestMethod.GET)
    public CommonResult<Integer>getMovieNumByComment(){
        long begin = Calendar.getInstance().getTime().getTime();
        int countByComment = movieService.getCountByComment(3.0);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success(end-begin,countByComment);
    }



    @ApiOperation("13. 某演员某年参演的电影数")
    @RequestMapping(value = "/13",method = RequestMethod.GET)
    public CommonResult<Integer>getMovieNumByActorYear(@RequestParam("name")String name,
                                                       @RequestParam("year")int year){

        long begin = Calendar.getInstance().getTime().getTime();
        int countByActorYear = movieService.getCountByActorYear(name, year);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success((end-begin),countByActorYear);

    }

    @ApiOperation("14. 某年某种类型电影数")
    @RequestMapping(value = "/15",method = RequestMethod.GET)
    public CommonResult<Integer>getMovieNumByStyleYear(@RequestParam("year")int year,
                                                       @RequestParam("style")String style){
        long begin = Calendar.getInstance().getTime().getTime();
        int countByyearStyle = movieService.getCountByyearStyle(year, style);
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success((end-begin),countByyearStyle);
    }


    @ApiOperation("15.哪两个演员合作次数最多 x")
    @RequestMapping(value = "/16",method = RequestMethod.GET)
    public CommonResult<JSONObject> cooperationMax(){
        long begin = Calendar.getInstance().getTime().getTime();
        JSONObject cooperationMax = movieService.getCooperationMax();
        long end = Calendar.getInstance().getTime().getTime();
        return CommonResult.success((end-begin),cooperationMax);
    }



}
