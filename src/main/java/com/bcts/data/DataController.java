package com.bcts.data;

import java.util.Dictionary;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DataController {
    @Autowired
    private World service;

    @GetMapping("/")
    public String home(Model model){
        Bird[] birds = service.getBirds();
        model.addAttribute("allBirds", birds);
        return "index";
    }

    @GetMapping("/birds")
    public String birds(Model model){
        Bird[] birds = service.getBirds();
        model.addAttribute("allBirds", birds);
        return "birds";
    }

    @GetMapping("/breakdown")
    public String breakdown(Model model){
        Dictionary<String, Bird[]> colors = service.countByColor();
        Dictionary<String, Bird[]> diets = service.countByDiet();
        Dictionary<String, Bird[]> statuses = service.countByStatus();
        model.addAttribute("colors", colors);
        model.addAttribute("diets", diets);
        model.addAttribute("statuses", statuses);
        return "breakdown";
    }

    @GetMapping("/filterBy")
    public String filterBy(Model model, String color, String diet, String status){
        Bird[] birds = service.searchBy(color, diet, status);
        model.addAttribute("allBirds", birds);
        return "filterBy";
    }
}
