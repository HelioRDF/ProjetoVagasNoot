package com.mycompany.empresas;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mycompany.util.HibernateUtil;

public class EmpresaDAOHibernate implements EmpresaDAO {

	@Override
	public void salvar(EmpresaEntity empresa) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(empresa);
			// Confirma transação.
			transacao.commit();

		} catch (RuntimeException ex) {

			// Desfaz a transação caso entre no catch.
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;

		} finally {
			sessao.close();
		}
	}

	@Override
	public void atualizar(EmpresaEntity empresa) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(EmpresaEntity empresa) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmpresaEntity> listar() {
		
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			List<EmpresaEntity> empresaObj = null;

			try {
				Query consulta = sessao.getNamedQuery("EmpresaEntity.listar");
				empresaObj = consulta.list();
			} catch (RuntimeException ex) {

				throw ex;

			} finally {
				sessao.close();
			}

			return empresaObj;

		
	}

	@Override
	public EmpresaEntity buscaUsuario(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
