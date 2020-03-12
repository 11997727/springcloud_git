package com.example.spring_cloud_provider.service.impl;

import com.example.spring_cloud_provider.mapper.StudentMapper;
import model.entity.Students;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: spring_cloud_provider
 * @Package com.example.spring_cloud_provider.service.impl
 * @Description:
 * @date 2020/2/4 星期二 18:49
 */
@RestController
public class StudentServiceImpl {
    @Resource
    private StudentMapper studentMapper;

    @RequestMapping("/queryStudent")
    public Map<String, Object> queryStudent(@RequestParam("sid")Integer sid, @RequestParam("pwd")String pwd){
        Map<String,Object>map=new HashMap<>();
        map.put("code",4);
        Students students = studentMapper.selectStudents(sid, pwd);
        if(students!=null){
            map.put("code",0);
            map.put("data",students);
        }
        return map;
    }

    @RequestMapping("/del")
    public Map<String,Object>del(@RequestParam("sid")Integer sid){
        Map<String,Object>map=new HashMap<>();
        map.put("code",4);
        Integer del = studentMapper.del(sid);
        if(del>0){
            map.put("code",0);
        }
        return map;
    }



    @RequestMapping( value = "/add")
    public Map<String, Object> addStu(@RequestBody Students students){
        Map<String,Object>map=new HashMap<>();
        map.put("code",4);
        Integer add = studentMapper.add(students);
        if(add>0){
            map.put("code",0);
        }
        return map;
    }

    @RequestMapping("/update")
    Map<String, Object> update(@RequestBody Students students){
        Map<String,Object>map=new HashMap<>();
        map.put("code",4);
        Integer add = studentMapper.update(students);
        if(add>0){
            map.put("code",0);
        }
        return map;
    }

    @RequestMapping("/queryAll")
    Map<String, Object> queryAll(@RequestBody Map<String,Object>map){
        Map<String,Object>statusMap=new HashMap<String, Object>();
        statusMap.put("count",0);
        int page=Integer.parseInt(map.get("page").toString());
        int limit=Integer.parseInt(map.get("limit").toString());
        int index=(page-1)*limit;
        map.put("index",index);
        List<Students> Students = studentMapper.selectAll(map);
        long num = studentMapper.selectAllCount(map);
        if(num>0){
            statusMap.put("data",Students);
            statusMap.put("count",num);
        }
        return statusMap;
    }

    @RequestMapping("/test")
    public String test(){
        return "来自provider1";
    }

}
