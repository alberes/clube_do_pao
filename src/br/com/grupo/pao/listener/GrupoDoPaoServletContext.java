package br.com.grupo.pao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.grupo.pao.domain.LoginBean;
import br.com.grupo.pao.service.LoginServices;

public class GrupoDoPaoServletContext implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {		
		String email = "admin@clubedopao.com.br";
		String password = "admin";
		LoginBean loginBean = null;
		
		LoginServices loginServices = new LoginServices();
		loginBean = loginServices.authentication(email, password);
		
		if(loginBean == null){
			loginBean = new LoginBean(email, password);
			loginBean = loginServices.insert(loginBean);
			System.out.println("loginBean " + loginBean);
		}
		
	}

}
