package com.example.spring_cloud_consumer.service;

import com.example.spring_cloud_consumer.service.impl.StudentServiceImpl;
import model.entity.Students;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: spring_cloud_consumer
 * @Package com.example.spring_cloud_consumer.service
 * @Description:
 * @date 2020/2/4 星期二 17:59
 */
@FeignClient(value="provider",fallback = StudentServiceImpl.class)
public interface StudentService {

    @RequestMapping("/queryStudent")
    public Map<String, Object> queryStudent(@RequestParam("sid")Integer sid, @RequestParam("pwd")String pwd);

    @RequestMapping( value = "/add")
    public Map<String, Object> addStu(@RequestBody Students students);

    @RequestMapping("/del")
    public Map<String,Object>del(@RequestParam("sid")Integer sid);

    @RequestMapping("/update")
    Map<String, Object> update(@RequestBody Students students);

    @RequestMapping("/queryAll")
    Map<String, Object> queryAll(@RequestBody Map<String,Object>map);

    @RequestMapping("/test")
    public String test();
}
