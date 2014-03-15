package br.com.grupo.pao.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.grupo.pao.constant.Constants;
import br.com.grupo.pao.dao.GenericJPADAO;
import br.com.grupo.pao.dao.ScheduleMemberDAO;
import br.com.grupo.pao.domain.MemberBean;
import br.com.grupo.pao.domain.ScheduleMemberBean;

public class ScheduleMemberServices {
	
	private GenericJPADAO<ScheduleMemberBean, Date> dao;
	
	public ScheduleMemberServices() {
		super();
		dao = new ScheduleMemberDAO();
	}

	public List<ScheduleMemberBean> shedule(Date scheduleDate, List<MemberBean> allMembers){	
		
		Calendar calendar = Calendar.getInstance();
		List<ScheduleMemberBean> scheduleMembers = new ArrayList<ScheduleMemberBean>();
		List<ScheduleMemberBean> scheduleMembersReturn = new ArrayList<ScheduleMemberBean>();
		Date endDate = null;
		Integer daysOfWeek[] = new Integer[5];
		int indexDay = 0;
		
		//Cria a lista para cada dia da semana
		Map<Integer, List<MemberBean>> mappins = createMappins();
		
		calendar.setTime(scheduleDate);
				
		//Controle dos dias da semana
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		for(int i = 0; i < 7; i++){
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			//So dias uteis
			if(calendar.get(Calendar.DAY_OF_WEEK) > 1 && 
					calendar.get(Calendar.DAY_OF_WEEK) < 7){
				daysOfWeek[indexDay] = calendar.get(Calendar.DAY_OF_WEEK);
				indexDay++;
			}
		}
		
		//Adiciona os membros na lista do dia
		for(MemberBean memberBean : allMembers){
			List<MemberBean> list = mappins.get(memberBean.getDayOfWeek());
			list.add(memberBean);
		}
		
		//Controle da data final (Data agendada mais 30 dias
		calendar = Calendar.getInstance();
		calendar.setTime(scheduleDate);
		calendar.add(Calendar.DAY_OF_MONTH, 30);
		endDate = calendar.getTime();
		
		//Dias da semana
		for(int i = 0; i < 5; i++){
			//Membros do dia da semana
			List<MemberBean> members = mappins.get(daysOfWeek[i]);
			//Data agendada
			calendar = Calendar.getInstance();
			calendar.setTime(scheduleDate);
			
			//Nao tem membro para o dia cria um membro (dummy) para ser marcado
			if(members.isEmpty()){
				members.add(new MemberBean());
			}
			
			//Controle do proximo dia disponivel
			int compensate = 0;
			if(daysOfWeek[i] < calendar.get(Calendar.DAY_OF_WEEK)){
				compensate = 7 - calendar.get(Calendar.DAY_OF_WEEK) + daysOfWeek[i];
			}else if(daysOfWeek[i] > calendar.get(Calendar.DAY_OF_WEEK)){
				compensate = daysOfWeek[i] - calendar.get(Calendar.DAY_OF_WEEK);
			}
			calendar.add(Calendar.DAY_OF_MONTH, compensate);
			
			//Cria o agendamento
			int initialDay = calendar.get(Calendar.DAY_OF_MONTH);
			for(int day = initialDay; day < (initialDay + 30); day += 7){
				for(MemberBean memberBean : members){
					if(endDate.before(calendar.getTime())){
						break;
					}
					ScheduleMemberBean scheduleMemberBean = new ScheduleMemberBean(calendar.getTime(), memberBean);
					//Nao existe membro para data
					if(memberBean.getDate() == null){
						scheduleMemberBean.setMemberBean(null);
					}
					scheduleMembers.add(scheduleMemberBean);
					calendar.add(Calendar.DAY_OF_MONTH, 7);
				}
			}
			
		}
		
		//Ordena por data
		Collections.sort(scheduleMembers);
		
		//Salva a lista de membro
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT);
		dao.setEntityManager(emf.createEntityManager());
		
		dao.getEntityManager().getTransaction().begin();
		for(ScheduleMemberBean scheduleMemberBean : scheduleMembers){
			ScheduleMemberBean m = dao.update(scheduleMemberBean);
			scheduleMembersReturn.add(m);
		}
		dao.getEntityManager().getTransaction().commit();
		
		dao.getEntityManager().close();
		
		return scheduleMembersReturn;
	}
	
	public List<ScheduleMemberBean> schedules(Date date){
		Map<String, Date> mappins = new HashMap<String, Date>();
		List<ScheduleMemberBean> scheduleMembers = null;
		
		mappins.put("dateParam", date);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT);
		dao.setEntityManager(emf.createEntityManager());
		
		scheduleMembers = dao.findByNamedQueryAndNamedParams(ScheduleMemberBean.FINDA_BY_DATE, mappins);
		
		dao.getEntityManager().close();
		
		return scheduleMembers;
	}
	
	//Cria a lista para cada dia da semana
	private Map<Integer, List<MemberBean>> createMappins(){
		List<MemberBean> membersMonday = new ArrayList<MemberBean>();
		List<MemberBean> membersTuesday = new ArrayList<MemberBean>();
		List<MemberBean> membersWednesday = new ArrayList<MemberBean>();
		List<MemberBean> membersThuesday = new ArrayList<MemberBean>();
		List<MemberBean> membersFriday = new ArrayList<MemberBean>();
		
		Map<Integer, List<MemberBean>> mappins = new HashMap<Integer, List<MemberBean>>();
		
		mappins.put(2, membersMonday);
		mappins.put(3, membersTuesday);
		mappins.put(4, membersWednesday);
		mappins.put(5, membersThuesday);
		mappins.put(6, membersFriday);
		
		return mappins;
	}

}