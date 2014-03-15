package br.com.grupo.pao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=MemberBean.FIND_ALL, query="SELECT m FROM MemberBean m")
public class MemberBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "find.all";
	
	@Id
	private String email;
	
	private String name;
	
	private Date date;
	
	private Integer dayOfWeek;

	public MemberBean() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDayOfWeek() {
		if(dayOfWeek == null){
			dayOfWeek = new Integer(0);
		}
		return dayOfWeek;
	}

	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		MemberBean other = (MemberBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberBean [email=" + email + ", name=" + name + ", date="
				+ date + ", daysOfWeek=" + dayOfWeek + "]";
	}

}
