package com.mycompany.empresas;

public class EmpresaRN {

	EmpresaDAOHibernate dao;

	public void salvar(EmpresaEntity empresa) {
		dao= new EmpresaDAOHibernate();
		Long codigo = empresa.getCodigo();
		if (codigo == null || codigo == 0) {
			this.dao.salvar(empresa);

		} else {
			this.dao.atualizar(empresa);
		}
	}
	
	

}
