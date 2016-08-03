package com.mycompany.empresas;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.util.HibernateUtil;;

public class EmpresaDAOHibernate implements EmpresaDAO {

	public void salvar(EmpresaEntity contato) {
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
	public void salvarEmpresa(EmpresaEntity contato) {
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
	public void atualizar(EmpresaEntity empresa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			sessao.update(empresa);

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
	public void excluir(EmpresaEntity empresa) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(empresa);
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
	public List<EmpresaEntity> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<EmpresaEntity> empresaEntity = null;

		try {
			Query consulta = sessao.getNamedQuery("UsuarioEntity.listar");
			empresaEntity = consulta.list();
		} catch (RuntimeException ex) {

			throw ex;

		} finally {
			sessao.close();
		}

		return empresaEntity;

	}

	

	@Override
	public EmpresaEntity buscaUsuario(int codigo) {
	
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			EmpresaEntity empresaEntity = null;

			try {
				Query consulta = sessao.getNamedQuery("EmpresaEntity.buscarPorCodigo");
				consulta.setLong("codigo", codigo);

				empresaEntity = (EmpresaEntity) consulta.uniqueResult();
			} catch (RuntimeException ex) {
				throw ex;
			} finally {
				sessao.close();
			}

			return empresaEntity;

		}



}