package com.yuki.bigdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuki.bigdata.entity.Users;
import org.springframework.stereotype.Repository;

/**
* @author 86180
* @description 针对表【users】的数据库操作Mapper
* @createDate 2021-12-25 15:10:49
* @Entity com.yuki.bigdata.entity.Users
*/
@Repository
public interface UsersMapper extends BaseMapper<Users> {

}




