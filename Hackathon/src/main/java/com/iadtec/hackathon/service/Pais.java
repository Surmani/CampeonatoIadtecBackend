package com.iadtec.hackathon.service;

public class Pais {
	
    private Long id;
    private String nome;


    public Pais(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pais() {
	}

	public Pais(String nome) {
        this.nome = nome;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pais{" + "id=" + id + ", nome=" + nome + "}";
    }
}