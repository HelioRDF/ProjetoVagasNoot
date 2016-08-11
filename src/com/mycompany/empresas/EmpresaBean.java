package com.mycompany.empresas;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.mycompany.util.FacesUtil;

@ManagedBean(name = "empresaBean")
@ViewScoped
public class EmpresaBean {

	private EmpresaEntity empresaObj;
	private List<EmpresaEntity> listEmpresas;
	private List<EmpresaEntity> listEmpresasFiltrados;
	private String confirmarSenha;

	public void salvar() {

		String senha = empresaObj.getSenha();

		if (!senha.equals(this.confirmarSenha)) {

			FacesUtil.adicionarMsgErro("Confirmação de senha incorreta");
		} else

			try {
				EmpresaRN company = new EmpresaRN();

				final DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				final Calendar cal = Calendar.getInstance();
				String dataFormatada = "" + df.format(cal.getTime());
				empresaObj.setDataCadastro(dataFormatada);

				company.salvar(this.empresaObj);
				FacesUtil.adicionarMsgInfo("Salvo com sucesso:    " + empresaObj.toString());
				empresaObj = new EmpresaEntity();

			} catch (Exception e) {
				FacesUtil.adicionarMsgErro("???" + e.getStackTrace());
			}
	}

	public void carregar() {

		System.out.println("Entrou no IF empresas");
		try {

			EmpresaDAOHibernate empresaDAOHibernate = new EmpresaDAOHibernate();
			listEmpresas = empresaDAOHibernate.listar();

		} catch (RuntimeException e) {
			FacesUtil.adicionarMsgErro("Erro ao listar Usuarios");

		}
	}

	public EmpresaEntity getEmpresaObj() {
		if (empresaObj == null) {
			empresaObj = new EmpresaEntity();
		}

		return empresaObj;
	}

	public void setEmpresaObj(EmpresaEntity empresaObj) {
		this.empresaObj = empresaObj;
	}

	public List<EmpresaEntity> getListEmpresas() {
		return listEmpresas;
	}

	public void setListEmpresas(List<EmpresaEntity> listEmpresas) {
		this.listEmpresas = listEmpresas;
	}

	public List<EmpresaEntity> getListEmpresasFiltrados() {
		return listEmpresasFiltrados;
	}

	public void setListEmpresasFiltrados(List<EmpresaEntity> listEmpresasFiltrados) {
		this.listEmpresasFiltrados = listEmpresasFiltrados;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

}
