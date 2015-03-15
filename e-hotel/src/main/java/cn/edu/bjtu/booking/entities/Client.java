package cn.edu.bjtu.booking.entities;

import java.io.Serializable;

public class Client implements Serializable {
	
	private static final long serialVersionUID = -8069196246842449591L;
	private String email;
	private String firstname;
	private String lastname;
	private String password;
	
	public Client()
	{
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
