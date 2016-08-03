
package com.mycompany.empresas;

import java.util.List;

/**
 *
 * @author Helio Franca
 */
public interface EmpresaDAO {
    
     
    public void salvar(EmpresaEntity contato);
    

   
    public void atualizar(EmpresaEntity contato);
    

    
    public void excluir(EmpresaEntity contato);

    
    public List<EmpresaEntity> listar();

    
    public EmpresaEntity buscaUsuario(int codigo);

    
}
