package com.mycompany.empresas;

import java.util.List;

public interface EmpresaDAO {

	public void salvar(EmpresaEntity empresa);

	public void atualizar(EmpresaEntity empresa);

	public void excluir(EmpresaEntity empresa);

	public List<EmpresaEntity> listar();

	public EmpresaEntity buscaUsuario(int codigo);

}
