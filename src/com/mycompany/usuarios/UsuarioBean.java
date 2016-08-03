package com.mycompany.usuarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean {

	private UsuarioEntity usuarioEntity;
	private String confirmarSenha;
	private List<UsuarioEntity> listUsuarios;

	private List<UsuarioEntity> listUsuariosFiltrados;

	//
	// private List<Fabricante> listaFabricantes;
	// private List<Fabricante> listaFabricantesFiltrados;

	public String guardar() {
		return "x";
	}

	public void novo() {
		if (usuarioEntity.getNome() != "") {
			usuarioEntity = new UsuarioEntity();
		} else
			FacesUtil.adicionarMsgErro("Preencha o campo descrição");

	}

	public void salvar() {

		String senha = this.usuarioEntity.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			FacesUtil.adicionarMsgErro("Confirmação de senha incorreta");
			// return null;
		} else

			try {
				UsuarioRN user = new UsuarioRN();

				final DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				final Calendar cal = Calendar.getInstance();
				String dataFormatada = "" + df.format(cal.getTime());

				usuarioEntity.setDataCadastro(dataFormatada);

				user.salvar(this.usuarioEntity);
				FacesUtil.adicionarMsgInfo("Salvo com sucesso:    " + usuarioEntity.toString());
				usuarioEntity = new UsuarioEntity();

				// return "BemVindo";

			} catch (Exception e) {
				// e.printStackTrace(); //Debugar erros.
				
				
				String erro ="";
				
				if(e.getMessage()==erro){
					erro="Usuário já existe.";
				}
				
				FacesUtil.adicionarMsgErro(e.getMessage());

				FacesUtil.adicionarMsgErro(e.getLocalizedMessage());

				FacesUtil.adicionarMsgErro(e.getCause().getMessage());

				

			}

	}

	public void carregar() {

		try {

			UsuarioDAOHibernate usuarioDAOHibernate = new UsuarioDAOHibernate();
			listUsuarios = usuarioDAOHibernate.listar();

		} catch (RuntimeException e) {
			FacesUtil.adicionarMsgErro("Erro ao listar fabricantes");
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

	public List<UsuarioEntity> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<UsuarioEntity> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	public List<UsuarioEntity> getListUsuariosFiltrados() {
		return listUsuariosFiltrados;
	}

	public void setListUsuariosFiltrados(List<UsuarioEntity> listUsuariosFiltrados) {
		this.listUsuariosFiltrados = listUsuariosFiltrados;
	}

}
