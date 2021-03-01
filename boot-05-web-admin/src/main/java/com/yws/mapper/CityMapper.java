package com.yws.mapper;

import com.yws.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("select * from city where id = #{id}")
    public City getById(long id);
}
