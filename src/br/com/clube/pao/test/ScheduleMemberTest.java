package br.com.clube.pao.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import br.com.grupo.pao.domain.MemberBean;
import br.com.grupo.pao.domain.ScheduleMemberBean;
import br.com.grupo.pao.service.MemberServices;
import br.com.grupo.pao.service.ScheduleMemberServices;

public class ScheduleMemberTest extends TestCase {

	private String initialDate;
	
	private MemberServices memberServices;
	
	private ScheduleMemberServices scheduleMemberServices;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		memberServices = new MemberServices();
		scheduleMemberServices = new ScheduleMemberServices();
		initialDate = "10/03/2014";
	}

	@Test
	public void testNotNull() throws Exception{
		Date date = null;
		List<ScheduleMemberBean> scheduleMembers;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		date = df.parse(initialDate);
		List<MemberBean> members = memberServices.findAll();			
		scheduleMembers = scheduleMemberServices.shedule(date, members);
		assertNotNull(scheduleMembers);
	}
	
	@Test
	public void testNotEmpty() throws Exception{
		Date date = null;
		List<ScheduleMemberBean> scheduleMembers;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		date = df.parse(initialDate);
		List<MemberBean> members = memberServices.findAll();			
		scheduleMembers = scheduleMemberServices.shedule(date, members);
		assertTrue(scheduleMembers.size() > 0);
	}

}
