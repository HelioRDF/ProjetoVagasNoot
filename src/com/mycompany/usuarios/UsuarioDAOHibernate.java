package com.mycompany.usuarios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.util.HibernateUtil;

public class UsuarioDAOHibernate implements UsuarioDAO {

	public void salvar(UsuarioEntity contato) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(contato);
			transacao.commit(); // Confirma transa.

		} catch (RuntimeException ex) {

			if (transacao != null) {
				transacao.rollback(); // Desfaz a transa��o caso entre no catch
			}
			throw ex;

		} finally {
			sessao.close();
		}
	}

	@Override
	public void atualizar(UsuarioEntity contato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(UsuarioEntity contato) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UsuarioEntity> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioEntity buscaUsuario(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}