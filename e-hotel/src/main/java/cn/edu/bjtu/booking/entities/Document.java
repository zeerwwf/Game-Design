package cn.edu.bjtu.booking.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Document implements Serializable {

	private static final long serialVersionUID = -3862007822030355094L;
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	private String url;
	@ManyToOne
	@JoinColumn(name = "ROOM_ID")
	private Room room;
	@OneToOne
	@JoinColumn(name = "BILL_ID")
	private Bill bill;
	@ManyToOne
	@JoinColumn(name = "ESTABLISHMENT_ID")
	private Establishment establishment;
	
	public Document()
	{
		setRoom(new Room());
		setBill(new Bill());
		setEstablishment(new Establishment());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
}
