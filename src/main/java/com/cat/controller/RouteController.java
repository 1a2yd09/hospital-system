package com.cat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
