package com.iadtec.hackathon.estado;

public class Estado {
	
    private Long id;
    private String nome;
    private String uf;
    private String nomePais;
    private long pais;

    public Estado(Long id, String nome, String uf, String nomePais, long pais) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.pais = pais;
        this.nomePais = nomePais;
    }
    
    public Estado(Long id, String nome, String uf, long pais) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.pais = pais;
    }
    
    public Estado(String nome, String uf, long pais) {
        this.nome = nome;
        this.uf = uf;
        this.pais = pais;
    }

    public Estado() {
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
    
    public String getUF() {
        return uf;
    }

    public void setUF(String uf) {
        this.uf = uf;
    }
    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String pais) {
        this.nomePais = pais;
    }

	public long getPais() {
		return pais;
	}

	public void setPais(long pais) {
		this.pais = pais;
	}

//    @Override
//    public String toString() {
//        return "Estado{" + "id=" + id + ", nome=" + nome + ", UF=" + uf + ", País=" + pais.getNome()+"}";
//    }
    
}
