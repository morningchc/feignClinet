package com.example.demo.controller;

import com.example.demo.client.FeignClientTest;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/9/12.
 */
@RestController
@RequestMapping("/test")
public class Welcome {
    @Autowired
    private FeignClientTest feignClientTest;

    @GetMapping("/init")
    public String init(){
        return "I'm FeignClient";
    }

    @GetMapping("/test")
    public String test(){
        String msg = feignClientTest.test();
        return msg;
    }

    @GetMapping("/postTest")
    public String postTest(){
        String msg = "";
        User user = new User();
        user.setName("chc");
        user.setAge(18);
        user = feignClientTest.postTest(user);
        msg = user.getName()+ " "+user.getAge();
        return msg;
    }
    @GetMapping("/welcome/{message}")
    public String welcome(@PathVariable String message) {
        String msg = "";
        msg = feignClientTest.welcome(message);
        return msg;
    }
}
