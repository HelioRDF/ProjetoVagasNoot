package com.mycompany.usuarios;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.util.HibernateUtil;
import com.mycompany.usuarios.UsuarioEntity;;

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
	
	//Classe Salvar Teste para Usuario
	public void salvarUser(Usuario contato) {
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
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			sessao.update(contato);

			transacao.commit(); // Confirma transacao...

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
	public void excluir(UsuarioEntity contato) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(contato);
			transacao.commit(); // Confirma transa��o.

		} catch (RuntimeException ex) {

			if (transacao != null) {
				transacao.rollback(); // Desfaz a transa��o caso entre no catch
			}
			throw ex;

		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioEntity> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<UsuarioEntity> usuarioEntity = null;

		try {
			Query consulta = sessao.getNamedQuery("UsuarioEntity.listar");
			usuarioEntity = consulta.list();
		} catch (RuntimeException ex) {

			throw ex;

		} finally {
			sessao.close();
		}

		return usuarioEntity;

	}

	

	@Override
	public UsuarioEntity buscaUsuario(int codigo) {
	
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			UsuarioEntity usuarioEntity = null;

			try {
				Query consulta = sessao.getNamedQuery("UsuarioEntity.buscarPorCodigo");
				consulta.setLong("codigo", codigo);

				usuarioEntity = (UsuarioEntity) consulta.uniqueResult();
			} catch (RuntimeException ex) {
				throw ex;
			} finally {
				sessao.close();
			}

			return usuarioEntity;

		}


}