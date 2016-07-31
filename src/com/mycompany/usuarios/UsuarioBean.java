package com.mycompany.usuarios;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.mycompany.usuarios.UsuarioRN;
import com.mycompany.usuarios.UsuarioEntity;;

/**
 *
 * @author Helio Franca
 */

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {
	

    private UsuarioEntity usuarioEntity = new UsuarioEntity();
    private String confirmarSenha;

    
    public String guardar(){
    	return "x";
    }
		
		public String salvar() {
			FacesContext context = FacesContext.getCurrentInstance();

			String senha = this.usuarioEntity.getSenha();
			if (!senha.equals(this.confirmarSenha)) {
				FacesMessage facesMessage = new FacesMessage(
						"A senha não foi confirmada corretamente");
				context.addMessage(null, facesMessage);
				return null;
			}

			
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarioRN.salvar(this.usuarioEntity);

			
			
			return "BemVindo";
		}
	
    

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
