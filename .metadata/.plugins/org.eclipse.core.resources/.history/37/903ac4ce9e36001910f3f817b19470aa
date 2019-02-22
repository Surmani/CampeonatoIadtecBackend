package com.iadtec.hackathon.estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @RequestMapping("/estados")
    public List<Estado> findEstado() {
        
        return estadoService.findAll();
    }

    @RequestMapping("/estados/{userId}")
    public Estado findEstado(@PathVariable Long userId) {
        
        return estadoService.findById(userId);
    }
}
