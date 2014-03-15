package br.com.clube.pao.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import br.com.grupo.pao.domain.LoginBean;
import br.com.grupo.pao.service.LoginServices;

public class LoginTest extends TestCase {

	private LoginServices loginService;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		loginService = new LoginServices();
	}

	@Test
	public void test() {
		LoginBean loginBean = loginService.authentication("admin@clubedopao.com.br", "admin");
		assertNotNull(loginBean);
	}

}
