package cn.edu.bjtu.booking.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {
	
	public enum ClientType
	{
		CUSTOMER,
		ADMIN,
		STAFF
	}
	
	private static final long serialVersionUID = -8069196246842449591L;
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	private String email;
	private String firstname;
	private String lastname;
	private String password;
	private ClientType peopleType;
	
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

	public ClientType getPeopleType() {
		return peopleType;
	}

	public void setPeopleType(ClientType peopleType) {
		this.peopleType = peopleType;
	}
}
