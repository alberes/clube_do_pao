package br.com.clube.pao.action;

import com.opensymphony.xwork2.ActionContext;

import br.com.grupo.pao.constant.Constants;

public class RedirectAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;

	private String nextAction;
	
	public String execute(){
		
		if(!this.isLogin()){
			return Constants.LOGOUT;
		}
		
		if(Constants.SAVE_MEMBER.equals(nextAction)){
			return Constants.SAVE_MEMBER;
		}else if(Constants.SCHEDULE_MEMBERS.equals(nextAction)){
			return Constants.SCHEDULE_MEMBERS;
		}else if(Constants.LIST_SCHEDULE_MEMBERS.equals(nextAction)){
			return Constants.LIST_SCHEDULE_MEMBERS;
		}else if(Constants.LOGOUT.equals(nextAction)){
			ActionContext.getContext().getSession().remove(Constants.LOGIN);
			return Constants.LOGOUT;
		}else{
			return Constants.MAINTAIN;
		}
	}

	public String getNextAction() {
		return nextAction;
	}

	public void setNextAction(String nextAction) {
		this.nextAction = nextAction;
	}

}
