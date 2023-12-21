package com.yuki.bigdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuki.bigdata.entity.Review;
import org.springframework.stereotype.Repository;

/**
* @author 86180
* @description 针对表【review】的数据库操作Mapper
* @createDate 2021-12-25 15:10:49
* @Entity com.yuki.bigdata.entity.Review
*/
@Repository
public interface ReviewMapper extends BaseMapper<Review> {

}




