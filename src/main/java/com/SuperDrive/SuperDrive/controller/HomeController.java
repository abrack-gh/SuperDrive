package com.SuperDrive.SuperDrive.controller;


import com.SuperDrive.SuperDrive.service.FileItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private FileItemService fileItemService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("fileItems", fileItemService.getAll());
        return modelAndView;
    }

}
