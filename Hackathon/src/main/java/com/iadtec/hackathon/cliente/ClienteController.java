package com.iadtec.hackathon.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping("/clientes")
    public List<Cliente> findCliente() {
        
        return clienteService.findAll();
    }

    @RequestMapping("/cliente/{userId}")
    public Cliente findCliente(@PathVariable Long userId) {
        
        return clienteService.findById(userId);
    }
}