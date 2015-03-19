package cn.edu.bjtu.booking.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "period")
public class Period implements Serializable {

	private static final long serialVersionUID = 1712629986981418787L;
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	private Date dateBegin;
	private Date dateEnd;
	private boolean isClosed;
	private String title;
	private double price;
	@ManyToOne
	@JoinColumn(name = "ROOM_ID")
	private Room room;
	@ManyToOne
	@JoinColumn(name = "ESTABLISHMENT_ID")
	private Establishment establishment;
	
	public Period()
	{
		room = new Room();
		establishment = new Establishment();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
}
