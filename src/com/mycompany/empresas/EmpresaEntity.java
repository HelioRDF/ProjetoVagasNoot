package com.mycompany.empresas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "Tb_empresaEntity")
@NamedQueries({ @NamedQuery(name = "EmpresaEntity.listar", query = "SELECT empresaObj FROM	EmpresaEntity empresaObj"),
		@NamedQuery(name = "EmpresaEntity.buscarPorCodigo", query = "SELECT empresaObj FROM EmpresaEntity empresaObj WHERE empresaObj.codigo = :codigo") })

public class EmpresaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// -Empresa (codigo, nomeEmpresa, email, senha, cnpj, dataCadastro,
	// segmento);

    @Id
    @GeneratedValue(strategy = GenerationType. AUTO)
    @Column
    private Long codigo ;
    private String nomeEmpresa ;
    @NaturalId
    private String email ;
  
    private String cnpj;
    private String senha ;
    private String ramoEmpresa ;
    private String dataCadastro ;
    private String descricaoEmpresa ;


	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDescricaoEmpresa() {
		return descricaoEmpresa;
	}

	public void setDescricaoEmpresa(String descricaoEmpresa) {
		this.descricaoEmpresa = descricaoEmpresa;
	}

	public String getRamoEmpresa() {
		return ramoEmpresa;
	}

	public void setRamoEmpresa(String ramoEmpresa) {
		this.ramoEmpresa = ramoEmpresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpresaEntity other = (EmpresaEntity) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmpresaEntity [codigo=" + codigo + ", cnpj=" + cnpj + ", email=" + email + ", senha=" + senha
				+ ", nomeEmpresa=" + nomeEmpresa + ", ramoEmpresa=" + ramoEmpresa + ", dataCadastro=" + dataCadastro
				+ ", descriçãoEmpresa=" + descricaoEmpresa + "]";
	}

}