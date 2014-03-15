package br.com.clube.pao.action;

import br.com.grupo.pao.constant.Constants;
import br.com.grupo.pao.domain.LoginBean;
import br.com.grupo.pao.service.LoginServices;

import com.opensymphony.xwork2.ActionContext;


public class LoginAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	private LoginServices loginServices;
	
	private String email;
	
	private String password;
	
	public LoginAction(){
		super();
		loginServices = new LoginServices();
	}
	
	public String execute(){
		
		try{
			LoginBean loginBean = loginServices.authentication(getEmail(), getPassword());
			setEmail(null);
			setPassword(null);
			ActionContext.getContext().getSession().put(Constants.LOGIN, loginBean);
			if(loginBean == null){
				addActionError("Usuario e/ou senha invalido(s)");
				return Constants.FAIL;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constants.LOGIN;
		}
		
		return Constants.SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
