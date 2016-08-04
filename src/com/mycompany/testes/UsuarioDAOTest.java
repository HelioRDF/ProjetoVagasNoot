package com.mycompany.testes;

import org.junit.Ignore;
import org.junit.Test;

import com.mycompany.usuarios.UsuarioDAOHibernate;
import com.mycompany.usuarios.UsuarioEntity;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() {
		UsuarioEntity user1 = new UsuarioEntity();
	
		user1.setCpf("2342342342342sd34");
		
		user1.setEmail("sdfsdfdf@fdsfds");
		user1.setEstadoCivil("dsfsfsdfsd");
		
		user1.setNome("asdasd");
		user1.setSenha("123");
		user1.setSexo("asdd");
		
		user1.setDataNascimento("23-03-1989");

		UsuarioDAOHibernate dao = new UsuarioDAOHibernate();

		dao.salvar(user1);

	}

}
