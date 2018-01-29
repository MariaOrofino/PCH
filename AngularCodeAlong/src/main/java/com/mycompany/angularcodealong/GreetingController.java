/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.angularcodealong;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author n0147313
 */
@RestController
@CrossOrigin
public class GreetingController {

    private static final String template = "Hello there, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greetings(@RequestParam(value="name", defaultValue="world") String name) {
                return new Greeting(counter.incrementAndGet(), String.format(template, name));

    }

}
