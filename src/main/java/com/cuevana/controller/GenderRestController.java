package com.cuevana.controller;

import com.cuevana.model.Gender;
import com.cuevana.service.iface.GenderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gender")
@CrossOrigin("*")
public class GenderRestController {
    
    @Autowired
    private GenderService genderService;
    
    @GetMapping
    public List<Gender> getAll() {
        return this.genderService.getAll();
    }
}
