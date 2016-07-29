package com.mycompany.testes;

import com.mycompany.util.HibernateUtil;

public class GerarTabelasTest {
	
	
	public static void main(String[] args) {
	
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
		
		

	}

}
