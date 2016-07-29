package com.mycompany.usuarios;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Helio Franca
 */

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {
	
	public String salvar (){
		return "texto";
	}
    
    private UsuarioEntity usuarioEntity = new UsuarioEntity();
    private String confirmarSenha;

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
    
    
}
