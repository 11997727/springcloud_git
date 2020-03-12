package com.example.spring_cloud_provider.mapper;

import model.entity.Students;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: spring_cloud_provider
 * @Package com.example.spring_cloud_provider.mapper
 * @Description:
 * @date 2020/2/4 星期二 18:46
 */
public interface StudentMapper {

    Students selectStudents(@Param("sid")Integer sid,@Param("pwd")String pwd);

    Integer del(@Param("sid")Integer sid);

    Integer add(Students students);

    Integer update(Students students);


    List<Students>selectAll(@Param("map")Map<String,Object>map);

    Long selectAllCount(@Param("map")Map<String,Object>map);
}
