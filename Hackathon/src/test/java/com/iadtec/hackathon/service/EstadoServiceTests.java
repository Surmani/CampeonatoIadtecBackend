package com.iadtec.hackathon.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iadtec.hackathon.estado.Estado;
import com.iadtec.hackathon.estado.EstadoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoServiceTests {
	
	@Autowired 
	private EstadoService estadoService;
	
	@Test
	public void contextLoads() {
	}

	@Test 
	public void createPais() {
		//Estado savedEstado = estadoService.create(getEstado());
//		Estado estadoFromDb = estadoService.findByNome("São Paulo");
//		assertEquals("São Paulo", estadoFromDb.getNome());
	}
	
	private Estado getEstado() {
		Estado estado = new Estado("São Paulo","SP",(long)1);
		return estado;
	}

	@Test 
	public void deleteEstado() {
		//estadoService.delete(2);
//		Estado estadoFromDb = estadoService.findByNome("São Paulo");
//		assertEquals(null, estadoFromDb);
		
	}
	
	@Test 
	public void updatePais() {
		Estado estadoFromDb = estadoService.findByNome("Goiânia");
		Estado updEstado = new Estado(estadoFromDb.getId(), "São Paulo", "SP",(long) 1);
		estadoService.update(updEstado);
		estadoFromDb = estadoService.findByNome("São Paulo");
		assertEquals(updEstado, estadoFromDb);
	}
}
