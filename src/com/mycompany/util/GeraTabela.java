package com.mycompany.util;

import com.mycompany.util.HibernateUtil;

public class GeraTabela {
	
	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
		
		
		
	}

}
