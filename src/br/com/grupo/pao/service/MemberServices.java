package br.com.grupo.pao.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.grupo.pao.constant.Constants;
import br.com.grupo.pao.dao.GenericJPADAO;
import br.com.grupo.pao.dao.MemberDAO;
import br.com.grupo.pao.domain.MemberBean;

public class MemberServices {

	private GenericJPADAO<MemberBean, String> dao;

	public MemberServices() {
		super();
		dao = new MemberDAO();
	}
	
	public MemberBean insert(MemberBean memberBean){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT);
		dao.setEntityManager(emf.createEntityManager());
	
		dao.getEntityManager().getTransaction().begin();;
		MemberBean member = dao.update(memberBean);
		dao.getEntityManager().getTransaction().commit();
		dao.getEntityManager().close();
		
		return member;
	}
	
	public List<MemberBean> findAll(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT);
		dao.setEntityManager(emf.createEntityManager());
		
		List<MemberBean> list = dao.findAllWithNamedQuery(MemberBean.FIND_ALL);
		
		dao.getEntityManager().close();
		return list;
	}
	
	
}
