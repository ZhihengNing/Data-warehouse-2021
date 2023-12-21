package com.yuki.bigdata.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuki.bigdata.entity.AllAll;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author 86180
* @description 针对表【all_all】的数据库操作Mapper
* @createDate 2021-12-25 21:30:06
* @Entity com.yuki.bigdata.entity.AllAll
*/
@Repository
public interface AllAllMapper extends BaseMapper<AllAll> {

    List<JSONObject> getCountCooperationActor(@Param("crew") String crew);

    List<JSONObject> getCountCooperationDirector(@Param("crew") String crew);
}




