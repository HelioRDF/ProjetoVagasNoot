package com.mycompany.usuarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import com.mycompany.usuarios.UsuarioRN;
import com.mycompany.util.FacesUtil;

import com.mycompany.usuarios.UsuarioEntity;;

/**
 *
 * @author Helio Franca
 */

@SuppressWarnings("unused")
@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean {

	private UsuarioEntity usuarioEntity;
	private String confirmarSenha;

	public String guardar() {
		return "x";
	}

	public void salvar() {

		String senha = this.usuarioEntity.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			FacesUtil.adicionarMsgErro("Confirmação de senha incorreta");
			// return null;
		}

		try {
			UsuarioRN user = new UsuarioRN();

			final DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			final Calendar cal = Calendar.getInstance();
			String dataFormatada = "" + df.format(cal.getTime());

			usuarioEntity.setDataCadastro(dataFormatada);

			user.salvar(this.usuarioEntity);
			FacesUtil.adicionarMsgInfo("Salvo com sucesso:    " + usuarioEntity.toString());

			// return "BemVindo";

		} catch (Exception e) {
			// e.printStackTrace(); //Debugar erros.
			FacesUtil.adicionarMsgErro("Erro so tentar salvar Usuários: " + e.getMessage());

		}

	}

	public UsuarioEntity getUsuarioEntity() {

		if (usuarioEntity == null) {
			usuarioEntity = new UsuarioEntity();
		}

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
