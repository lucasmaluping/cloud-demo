package com.lucas.service.mapper;


import com.zpark.model.Country;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author Lucas
 * @Date 2019/12/17 14:12
 * @Version 1.0
 */

//Mapper<>中的参数的实体类对应数据库名字和实体类名字相同的表
public interface CountryMapper extends Mapper<Country> {

}
