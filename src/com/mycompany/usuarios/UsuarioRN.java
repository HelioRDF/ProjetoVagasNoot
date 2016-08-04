
package com.mycompany.usuarios;

//import com.mycompany.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Helio Franca
 */
public class UsuarioRN {
	private UsuarioDAOHibernate dao;

	public UsuarioRN() {
		dao = new UsuarioDAOHibernate();
	}

	public void salvar(UsuarioEntity usuario) {
		Long codigo = usuario.getCodigo();
		if (codigo == null || codigo == 0) {
			// usuario.getPermissao().add("ROLE_USUARIO");
			this.dao.salvar(usuario);
		} else {
			this.dao.atualizar(usuario);
		}
	}

	public void excluir(UsuarioEntity usuario) {
		this.dao.excluir(usuario);
	}

	public List<UsuarioEntity> listar() {
		return this.dao.listar();
	}

}