package br.com.clube.pao.test;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import br.com.grupo.pao.domain.MemberBean;
import br.com.grupo.pao.service.MemberServices;

public class MemberTest extends TestCase {

	private MemberServices memberServices;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		memberServices = new MemberServices();
	}

	@Test
	public void testNotNull() {
		MemberBean memberBean = new MemberBean();
		memberBean.setName("Member1");
		memberBean.setEmail("member1@clubedopao.com.br");
		memberBean.setDate(new Date());
		memberBean.setDayOfWeek(2);
		
		MemberBean memberBeanReturn = memberServices.insert(memberBean);
		
		assertNotNull(memberBeanReturn);
	}

}
