package com.mycompany.usuarios;

import java.util.List;

/**
 *
 * @author Helio Franca
 */
public interface UsuarioDAO {

	public void salvar(UsuarioEntity contato);

	public void atualizar(UsuarioEntity contato);

	public void excluir(UsuarioEntity contato);

	public List<UsuarioEntity> listar();

	public UsuarioEntity buscaUsuario(int codigo);

}
