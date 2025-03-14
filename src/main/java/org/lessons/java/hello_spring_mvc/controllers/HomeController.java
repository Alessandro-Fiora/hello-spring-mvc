package org.lessons.java.hello_spring_mvc.controllers;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/saluta")
    public String saluta(Model model, @RequestParam("name") String name) {

        model.addAttribute("name", name);
        model.addAttribute("time", LocalTime.now());

        return "saluta";
    }

    @GetMapping("/coffeeshop/{id}")
    public String coffeeShop(Model model, @PathVariable("id") int id, @RequestParam ("name") String name) {


        String item;

        switch (id) {
            case 1:
                item = "caffè";
                break;
            case 2:
                item = "cappuccio";
                break;
            case 3:
                item = "spremuta d'arancia";
                break;
        
            default:
                item = "quello che hai ordinato";
                break;
        }

        model.addAttribute("item", item);
        model.addAttribute("name", name);
        return "coffeeShop";
    }
    
    

    
}
