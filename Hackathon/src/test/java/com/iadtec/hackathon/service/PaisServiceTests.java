package com.iadtec.hackathon.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaisServiceTests {
	
	@Autowired 
	private PaisService paisService;
	
	@Test
	public void contextLoads() {
	}

	@Test 
	public void createPais() {
//		Pais savedPais = paisService.create(getPais());
//		Pais paisFromDb = paisService.findByNome("Ucrânia");
//		assertEquals("Ucrânia", paisFromDb.getNome());
	}
	
	private Pais getPais() {
		Pais pais = new Pais("Ucrânia");
		return pais;
	}

	@Test 
	public void deletePais() {
//		Pais paisFromDb = paisService.findByNome("Ucrânia");
//		assertEquals("Ucrânia", paisFromDb.getNome());
//		paisService.delete(106);
//		paisFromDb = paisService.findByNome("Ucrânia");
//		assertEquals(null, paisFromDb);
		
	}
	
	@Test 
	public void updatePais() {
		Pais paisFromDb = paisService.findByNome("Ucrânia");
		assertEquals("Ucrânia", paisFromDb.getNome());
		Pais updPais = new Pais(paisFromDb.getId(), "Polônia");
		paisService.update(updPais);
		paisFromDb = paisService.findByNome("Polônia");
		assertEquals(updPais, paisFromDb);
	}
}
