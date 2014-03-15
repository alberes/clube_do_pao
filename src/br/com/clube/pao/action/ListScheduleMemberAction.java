package br.com.clube.pao.action;

import java.util.Calendar;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import br.com.grupo.pao.constant.Constants;
import br.com.grupo.pao.domain.ScheduleMemberBean;
import br.com.grupo.pao.service.ScheduleMemberServices;

public class ListScheduleMemberAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	List<ScheduleMemberBean> scheduleMembers;
	
	private ScheduleMemberServices scheduleMemberServices;
	
	public ListScheduleMemberAction() {
		super();
		scheduleMemberServices = new ScheduleMemberServices();
	}
	
	
	@SuppressWarnings("unchecked")
	public String execute(){
		
		if(!this.isLogin()){
			return Constants.LOGIN;
		}
		
		scheduleMembers = (List<ScheduleMemberBean>) ActionContext.getContext().getSession().get("scheduleMembers");
		
		//Nao foi do cadastro
		if(scheduleMembers == null){
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, -1);
			calendar.set(Calendar.SECOND, 0);
			try{
				scheduleMembers = scheduleMemberServices.schedules(calendar.getTime());
			}catch(Exception e){
				e.printStackTrace();
				return Constants.MAINTAIN;
			}
		}else{
			ActionContext.getContext().getSession().remove("scheduleMembers");
		}
		
		return Constants.SUCCESS;
	}

	public List<ScheduleMemberBean> getScheduleMembers() {
		return scheduleMembers;
	}

	public void setScheduleMembers(List<ScheduleMemberBean> scheduleMembers) {
		this.scheduleMembers = scheduleMembers;
	}

}
