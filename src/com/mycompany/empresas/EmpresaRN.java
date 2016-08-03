
package com.mycompany.empresas;

//import com.mycompany.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Helio Franca
 */
public class EmpresaRN {
    private EmpresaDAOHibernate empresaDAO;

    public EmpresaRN() {
    	empresaDAO = new EmpresaDAOHibernate();
    }


	
	public void salvar(EmpresaEntity empresa) {
		Long codigo = empresa.getCodigo();
		if (codigo == null || codigo == 0) {
	//		usuario.getPermissao().add("ROLE_USUARIO"); 
			this.empresaDAO.salvar(empresa);
		} else {
			this.empresaDAO.atualizar(empresa);
		}
	}

	public void excluir(EmpresaEntity empresa) {
		this.empresaDAO.excluir(empresa);
	}

	public List<EmpresaEntity> listar() {
		return this.empresaDAO.listar();
	}
	
	
}