package com.coffeehause.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @GetMapping("/")
    public String showHomePage(Map<String, Object> model){
        String id = "";
        model.put("path", id);
        return "index.html";}
    @PostMapping("/")
    public String goToEvent(@RequestParam(name="path") String event_id){
        return "redirect:/event/" + event_id;
    }
}
