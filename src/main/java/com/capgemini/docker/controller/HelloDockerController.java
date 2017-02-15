package com.capgemini.docker.controller;

import com.capgemini.docker.domain.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sanrawat on 2/3/2017.
 */

@RestController
public class HelloDockerController {

    private static int id = 0;

    @GetMapping(path="/")
    public Message helloDocker(){
        id++;
        return new Message(id, "Hello Docker in AWS");
    }

    @GetMapping(path="/message")
    public String helloMessage(){
        return "Hello Docker";
    }
}
