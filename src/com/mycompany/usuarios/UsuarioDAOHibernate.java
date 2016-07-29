package com.mycompany.usuarios;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAOHibernate implements UsuarioDAO {

    private  Session sessao; 

    public void setSession(Session sessao) {
        this.sessao = sessao;
    }

    public void salvar(UsuarioEntity contato) {
        sessao.save(contato);
    }

    public void atualizar(UsuarioEntity contato) {
        sessao.update(contato);
    }

    public void excluir(UsuarioEntity contato) {
        sessao.delete(contato);
    }

    @SuppressWarnings("unchecked")
    public List<UsuarioEntity> listar() {
        Query consulta = sessao.createQuery("from UsuarioEntity");
        return consulta.list();
    }

    public UsuarioEntity buscaUsuario(int codigo) {
        Query consulta = sessao.createQuery("from UsuarioEntity where codigo = :parametro");
        consulta.setInteger("parametro", codigo);
        return (UsuarioEntity) consulta.uniqueResult();
    }

}
