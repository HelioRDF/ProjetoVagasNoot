package com.mycompany.empresas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.util.FacesUtil;;

/**
 *
 * @author Helio Franca
 */

@ManagedBean(name = "empresaBean")
@ViewScoped
public class EmpresaBean {

	private EmpresaEntity empresaEntity;
	private String confirmarSenha;
	private List<EmpresaEntity> listEmpresa;
	private List<EmpresaEntity> listEmpresaFiltrados;

	public String guardar() {
		return "x";
	}

	//Não está sendo utilizado.
	public void novo() {
		if (empresaEntity.getNome() != "") {
			empresaEntity = new EmpresaEntity();
		} else
			FacesUtil.adicionarMsgErro("Preencha o campo descrição");

	}

	public void salvar() {

		String senha = this.empresaEntity.getSenha();
		
		if (!senha.equals(this.confirmarSenha)) {
			FacesUtil.adicionarMsgErro("Confirmação de senha incorreta");
			// return null;
		} else

			try {
				EmpresaRN empresa = new EmpresaRN();

				final DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				final Calendar cal = Calendar.getInstance();
				String dataFormatada = "" + df.format(cal.getTime());

				empresaEntity.setDataCadastro(dataFormatada);

				empresa.salvar(this.empresaEntity);
				FacesUtil.adicionarMsgInfo("Salvo com sucesso:    " + empresaEntity.toString());
				empresaEntity = new EmpresaEntity();


			} catch (Exception e) {
				// e.printStackTrace(); //Debugar erros.

				String erro = "";

				if (e.getMessage() == erro) {
					erro = "Usuário já existe.";
				}

				FacesUtil.adicionarMsgErro(e.getMessage() + empresaEntity.toString());


			}

	}

	public void carregar() {

		try {

			EmpresaDAOHibernate empresaDAOHibernate = new EmpresaDAOHibernate();
			listEmpresa = empresaDAOHibernate.listar();

		} catch (RuntimeException e) {
			FacesUtil.adicionarMsgErro("Erro ao listar Empresas");
		}
	}

	public EmpresaEntity getEmpresaEntity() {
		return empresaEntity;
	}

	public void setEmpresaEntity(EmpresaEntity empresaEntity) {
		this.empresaEntity = empresaEntity;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public List<EmpresaEntity> getListEmpresa() {
		return listEmpresa;
	}

	public void setListEmpresa(List<EmpresaEntity> listEmpresa) {
		this.listEmpresa = listEmpresa;
	}

	public List<EmpresaEntity> getListEmpresaFiltrados() {
		return listEmpresaFiltrados;
	}

	public void setListEmpresaFiltrados(List<EmpresaEntity> listEmpresaFiltrados) {
		this.listEmpresaFiltrados = listEmpresaFiltrados;
	}

}
