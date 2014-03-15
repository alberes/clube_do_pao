package br.com.clube.pao.action;

import br.com.grupo.pao.constant.Constants;
import br.com.grupo.pao.domain.LoginBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	public boolean isLogin(){
		LoginBean loginBean = (LoginBean) ActionContext.getContext().getSession().get(Constants.LOGIN);
		return loginBean != null;
	}

}
