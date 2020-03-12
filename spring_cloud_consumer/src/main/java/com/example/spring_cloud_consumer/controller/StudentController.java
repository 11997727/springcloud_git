package com.example.spring_cloud_consumer.controller;

import com.alibaba.fastjson.JSON;
import com.example.spring_cloud_consumer.service.StudentService;
import model.entity.Students;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: spring_cloud_consumer
 * @Package com.example.spring_cloud_consumer.controller
 * @Description:
 * @date 2020/2/4 星期二 18:00
 */
@RestController
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("/login")
    public String login(@RequestParam("sid") Integer sid,@RequestParam("pwd")String pwd){
        Map<String, Object> map = studentService.queryStudent(sid, pwd);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/del")
    public String del(@RequestParam("sid")Integer sid){
        Map<String, Object> del = studentService.del(sid);
        return JSON.toJSONString(del);
    }


    @RequestMapping(value = "/add")
    public String add(@RequestBody Students students){
        Map<String, Object> map = studentService.addStu(students);
        return JSON.toJSONString(map);
    }


    @RequestMapping(value = "/update")
    public String update(@RequestBody Students students){
        Map<String, Object> map = studentService.update(students);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/queryAll")
    public String queryAll(@RequestParam(value = "limit",required = false,defaultValue = "5") Integer limit,
                             @RequestParam(value = "page",required = false,defaultValue = "1") Integer page){
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("limit",limit);
        map.put("page",page);
        Map<String, Object> map1 = studentService.queryAll(map);
        return JSON.toJSONString(map1);
    }

    @RequestMapping(value = "/test")
    public String test(){
      return  studentService.test();
    }
}
