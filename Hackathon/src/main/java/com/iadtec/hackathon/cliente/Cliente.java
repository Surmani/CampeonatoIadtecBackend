package com.iadtec.hackathon.cliente;

import java.util.Date;

import com.iadtec.hackathon.estado.Estado;

public class Cliente {
	
    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String email;
    private String situacao;
    private String estado;

    public Cliente(Long id, String nome, String cpf, Date dataNascimento, String email, String situacao, String estado) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.setDataNascimento(dataNascimento);
        this.setEmail(email);
        this.setSituacao(situacao);
        this.estado = estado;
    }

    public Cliente() {
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
    
    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

//    @Override
//    public String toString() {
//        return "Estado{" + "id=" + id + ", nome=" + nome + ", CPF=" + cpf + ", Estado=" + estado.getNome()+"}";
//    }

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
    
}
