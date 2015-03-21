package cn.edu.bjtu.booking.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "establishment")
public class Establishment implements Serializable {

	private static final long serialVersionUID = -3501499216419392574L;
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	private String title;
	private String description;
	private String address;
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	
	public Establishment()
	{
		client = new Client();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
