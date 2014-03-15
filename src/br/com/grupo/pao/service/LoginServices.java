package br.com.grupo.pao.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.grupo.pao.constant.Constants;
import br.com.grupo.pao.dao.GenericJPADAO;
import br.com.grupo.pao.dao.LoginDAO;
import br.com.grupo.pao.domain.LoginBean;

public class LoginServices {
	
	private GenericJPADAO<LoginBean, String> dao;
	
	public LoginServices(){
		super();
		dao = new LoginDAO();
	}
	
	public LoginBean authentication(String email, String password){
		Map<String, String> mappins = new HashMap<String, String>();
		List<LoginBean> logins = null;
		LoginBean login = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT);
		dao.setEntityManager(emf.createEntityManager());

		mappins.put("email", email);
		mappins.put("password", password);
		logins = dao.findByNamedQueryAndNamedParams(LoginBean.LOGIN_QUERY, mappins);
		
		if(logins.size() == 1){
			login = logins.get(0);
		}
		
		dao.getEntityManager().close();
		return login;
	}
	
	public LoginBean insert(LoginBean loginBean){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT);
		dao.setEntityManager(emf.createEntityManager());
	
		dao.getEntityManager().getTransaction().begin();;
		LoginBean login = dao.save(loginBean);
		dao.getEntityManager().getTransaction().commit();
		dao.getEntityManager().close();
		
		return login;
	}

}
