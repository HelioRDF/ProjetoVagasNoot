package com.mycompany.testes;

import org.junit.Test;

import com.mycompany.usuarios.UsuarioDAOHibernate;
import com.mycompany.usuarios.UsuarioEntity;

public class UsuarioDAOTest {

	@Test
	public void salvar(){
		UsuarioEntity user1 = new UsuarioEntity();
		user1.setNome("Helio");
		user1.setCpf("asdadsdasdadasd");
		user1.setEmail("dsafsdfsdf@sdfsdfsdfsf");
		user1.setEstadoCivil("dfsfdfsdfsd");
		user1.setLogin("sdfsdfsdf");
		user1.setRg("dsfsdfdsfdsf");
		user1.setSexo("dfsfsdfsd");
		
		
		
		UsuarioDAOHibernate dao = new UsuarioDAOHibernate();
		
		dao.salvar(user1);
		
		
	}
	
}
