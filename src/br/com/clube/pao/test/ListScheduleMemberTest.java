package br.com.clube.pao.test;

import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import br.com.grupo.pao.domain.ScheduleMemberBean;
import br.com.grupo.pao.service.ScheduleMemberServices;

public class ListScheduleMemberTest extends TestCase {

	private List<ScheduleMemberBean> scheduleMembers;
	
	private ScheduleMemberServices scheduleMemberServices;
	
	private Calendar calendar;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		scheduleMemberServices = new ScheduleMemberServices();
		calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
	}

	@Test
	public void testNotNull() {		
		scheduleMembers = scheduleMemberServices.schedules(calendar.getTime());
		assertNotNull(scheduleMembers);
	}
	
	@Test
	public void testNotEmpty() {		
		scheduleMembers = scheduleMemberServices.schedules(calendar.getTime());
		assertTrue(scheduleMembers.size() > 0);
	}
	
	@Test
	public void testDayOfWeek() {		
		scheduleMembers = scheduleMemberServices.schedules(calendar.getTime());
		
		for(ScheduleMemberBean scheduleMemberBean : scheduleMembers){
			calendar.setTime(scheduleMemberBean.getDate());
			if(scheduleMemberBean.getMemberBean() != null){
				assertTrue(calendar.get(Calendar.DAY_OF_WEEK) == 2);
			}
		}
	}

}
