package br.com.clube.pao.action;

import java.util.Date;

import br.com.grupo.pao.constant.Constants;
import br.com.grupo.pao.domain.MemberBean;
import br.com.grupo.pao.service.MemberServices;

public class SaveMemberAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String email;
	
	private Integer dayOfWeek;
	
	private MemberServices memberServices;
	
	public SaveMemberAction() {
		super();
		memberServices = new MemberServices();
	}

	public String execute(){
		
		boolean valid = true;
		
		if(!this.isLogin()){
			return Constants.LOGIN;
		}
		
		if(name == null || "".equals(name.trim())){
			addActionError("O campo Nome e obrigatorio");
			valid = false;
		}
		if(email == null || "".equals(email.trim())){
			addActionError("O campo e-mail e obrigatorio");
			valid = false;
		}
		if(dayOfWeek == null){
			addActionError("O campo dia e obrigatorio");
			valid = false;
		}else if(dayOfWeek < 2 && dayOfWeek > 6){
			addActionError("Intervalo invalido para o atributo dia");
			valid = false;
		}
		
		if(!valid){
			return Constants.FAIL;
		}
		
		MemberBean memberBean = new MemberBean();
		memberBean.setName(getName());
		memberBean.setEmail(getEmail());
		memberBean.setDate(new Date());
		memberBean.setDayOfWeek(getDayOfWeek());
		
		try{
			memberServices.insert(memberBean);
			setName(null);
			setEmail(null);
			setDayOfWeek(null);
		}catch(Exception e){
			e.printStackTrace();
			return Constants.MAINTAIN;
		}
		
		return Constants.SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

}
