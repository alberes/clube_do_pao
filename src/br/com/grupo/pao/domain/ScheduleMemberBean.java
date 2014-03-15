package br.com.grupo.pao.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=ScheduleMemberBean.FINDA_BY_DATE, query="SELECT s FROM ScheduleMemberBean s WHERE s.date >= :dateParam")
public class ScheduleMemberBean implements Comparable<ScheduleMemberBean> {

	public final static String FINDA_BY_DATE = "find.by.date";
	
	@Id
	private Date date;
	
	private MemberBean memberBean;

	public ScheduleMemberBean() {
		super();
	}

	public ScheduleMemberBean(Date date, MemberBean memberBean) {
		super();
		this.date = date;
		this.memberBean = memberBean;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((memberBean == null) ? 0 : memberBean.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduleMemberBean other = (ScheduleMemberBean) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (memberBean == null) {
			if (other.memberBean != null)
				return false;
		} else if (!memberBean.equals(other.memberBean))
			return false;
		return true;
	}

	@Override
	public int compareTo(ScheduleMemberBean o) {
		return this.getDate().compareTo(o.getDate());
	}
	
	@Override
	public String toString() {
		return "ScheduleMember [date=" + date + ", memberBean=" + memberBean
				+ "]";
	}	
	
}
