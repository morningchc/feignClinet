package com.example.demo.client;

import com.example.demo.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Administrator on 2018/9/12.
 */

@FeignClient(name="CLIENT")
public interface FeignClientTest {
    @GetMapping(value = "/welcome/test")
    String test();

    @PostMapping(value = "/welcome/postTest")
    User postTest(@RequestBody User user);

    @GetMapping (value = "/welcome/welcome/{message}")
    String welcome(@PathVariable(value = "message") String message);

}
