package com.mycompany.usuarios;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.NaturalId;

/* Essa Classe contempla as informações do usuário.
 * Usuários ( Codigo, NOME, LOGIN, DATANASC, ESTADOCIVIL, RG, CPF, SEXO, SENHA);
 */
@Entity
@Table(name = "usuarioentity")
public class UsuarioEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5456763130001805704L;

	@Id
    @GeneratedValue
    private Integer codigo;

    private String nome;

    @NaturalId
    private String login;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    private String dataNascimento;
    private String estadoCivil;
    private String rg;
    private String cpf;
    private String sexo;
    private String senha;
    private String email;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getRg() {
        return rg;
    }

    @Column(length = 9)
    public void setRg(String rg) {
        this.rg = rg;
    }

    @Column(length = 11)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

}
