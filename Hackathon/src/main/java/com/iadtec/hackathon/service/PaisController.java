package com.iadtec.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisController {

    @Autowired
    private PaisService paisService;

    @RequestMapping("/paises")
    public List<Pais> findCities() {
        
        return paisService.findAll();
    }

    @RequestMapping("/paises/{userId}")
    public Pais findPais(@PathVariable Long userId) {
        
        return paisService.findById(userId);
    }
}
