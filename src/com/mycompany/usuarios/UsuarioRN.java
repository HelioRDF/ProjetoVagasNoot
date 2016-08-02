
package com.mycompany.usuarios;

//import com.mycompany.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Helio Franca
 */
public class UsuarioRN {
    private UsuarioDAOHibernate usuarioDAO;

    public UsuarioRN() {
    	usuarioDAO = new UsuarioDAOHibernate();
    }


	
	public void salvar(UsuarioEntity usuario) {
		Long codigo = usuario.getCodigo();
		if (codigo == null || codigo == 0) {
	//		usuario.getPermissao().add("ROLE_USUARIO"); 
			this.usuarioDAO.salvar(usuario);
		} else {
			this.usuarioDAO.atualizar(usuario);
		}
	}

	public void excluir(UsuarioEntity usuario) {
		this.usuarioDAO.excluir(usuario);
	}

	public List<UsuarioEntity> listar() {
		return this.usuarioDAO.listar();
	}
	
	
}