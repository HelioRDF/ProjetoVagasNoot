package com.mycompany.util;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UsuarioTeste {

	
	@Id
	Long codigo;
	
	String nome;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
