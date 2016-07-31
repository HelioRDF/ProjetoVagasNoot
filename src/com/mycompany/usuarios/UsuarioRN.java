/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
      //  this.usuarioDAO = DAOFactory.criarUsuarioDAO();
        
    }


	
	public void salvar(UsuarioEntity usuario) {
		Integer codigo = usuario.getCodigo();
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