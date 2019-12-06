/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.friendshub.friendshub;

import com.friendshub.friendshub.domains.Greeting;
import com.friendshub.friendshub.domains.User;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
        
    }
    
    @RequestMapping("/users")
    public List<User> userList() {
        return userRepository.findAll();
        
    }
    @RequestMapping("/user")
    public User user(@RequestParam(value = "name") String name) {
        return userRepository.findUser(name);
        
    }
}
