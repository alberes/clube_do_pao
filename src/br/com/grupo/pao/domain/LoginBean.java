package br.com.grupo.pao.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=LoginBean.LOGIN_QUERY, query="SELECT l FROM LoginBean l WHERE l.email =:email AND l.password =:password")
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String LOGIN_QUERY = "LoginBean.findLogin";

	@Id
	private String email;
	
	private String password;

	public LoginBean() {
		super();
	}

	public LoginBean(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		LoginBean other = (LoginBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginBean [email=" + email + "]";
	}	
	
}
