package br.com.clube.pao.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.grupo.pao.constant.Constants;
import br.com.grupo.pao.domain.MemberBean;
import br.com.grupo.pao.domain.ScheduleMemberBean;
import br.com.grupo.pao.service.MemberServices;
import br.com.grupo.pao.service.ScheduleMemberServices;

import com.opensymphony.xwork2.ActionContext;

public class ScheduleMemberAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String initialDate;
	
	private MemberServices memberServices;
	
	private ScheduleMemberServices scheduleMemberServices;
	
	public ScheduleMemberAction() {
		super();
		memberServices = new MemberServices();
		scheduleMemberServices = new ScheduleMemberServices();
	}

	public String execute(){
		
		boolean valid = true;
		Date date = null;
		
		if(!this.isLogin()){
			return Constants.LOGIN;
		}
		
		if(initialDate == null || "".equals(initialDate.trim())){
			addActionError("O campo data e obrigatorio");
			valid = false;
		}
		
		if(!valid){
			return Constants.FAIL;
		}
		
		try{
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			date = df.parse(getInitialDate());
		}catch(Exception e){
			addActionError("Formato da data invalida");
			return Constants.FAIL;
		}
		
		List<ScheduleMemberBean> scheduleMembers;
		try{			
			List<MemberBean> members = memberServices.findAll();			
			scheduleMembers = scheduleMemberServices.shedule(date, members);
			ActionContext.getContext().getSession().put("scheduleMembers", scheduleMembers);
		}catch(Exception e){
			e.printStackTrace();
			return Constants.MAINTAIN;
		}
		
		return Constants.SUCCESS;
	}

	public String getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}

}
