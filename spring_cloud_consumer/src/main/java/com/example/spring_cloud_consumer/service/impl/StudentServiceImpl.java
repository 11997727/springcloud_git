package com.example.spring_cloud_consumer.service.impl;

import com.example.spring_cloud_consumer.service.StudentService;
import model.entity.Students;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: spring_cloud_consumer
 * @Package com.example.spring_cloud_consumer.service.impl
 * @Description:
 * @date 2020/2/5 星期三 10:25
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public Map<String, Object> queryStudent(Integer sid, String pwd) {
       Map<String,Object>map=new HashMap<>();
        map.put("msg","请稍后再试");
        return map;
    }

    @Override
    public Map<String, Object> addStu(Students students) {
        Map<String,Object>map=new HashMap<>();
        map.put("msg","请稍后再试");
        return map;
    }

    @Override
    public Map<String, Object> del(Integer sid) {
        Map<String,Object>map=new HashMap<>();
        map.put("msg","请稍后再试");
        return map;
    }

    @Override
    public Map<String, Object> update(Students students) {
        Map<String,Object>map=new HashMap<>();
        map.put("msg","请稍后再试");
        return map;
    }

    @Override
    public Map<String, Object> queryAll(Map<String, Object> map) {
        Map<String,Object>map1=new HashMap<>();
        map1.put("msg","请稍后再试");
        return map1;
    }

    @Override
    public String test() {
        return "请稍后再试";
    }
}
