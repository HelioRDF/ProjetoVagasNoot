package com.mycompany.empresas;

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
	

	public void salvar() {

		try {
			EmpresaRN company = new EmpresaRN();

			company.salvar(this.empresaObj);
			FacesUtil.adicionarMsgInfo("Salvo com sucesso:    " + empresaObj.toString());
			empresaObj = new EmpresaEntity();

		} catch (Exception e) {
			FacesUtil.adicionarMsgErro("???"+ e.getStackTrace() );
			
		}

	}
	
	public void carregar() {

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

	
}
