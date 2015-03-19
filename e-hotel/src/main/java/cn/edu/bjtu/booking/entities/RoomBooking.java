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
@Table(name = "roombooking")
public class RoomBooking implements Serializable {

	private static final long serialVersionUID = -283494533652972018L;

	public enum RoomState
	{
		FREE,
		BUSY,
		NOT_CLEAN,
		CLEAN
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	private double price;
	private RoomState state;
	@ManyToOne
	@JoinColumn(name = "BOOKING_ID")
	private Booking booking;
	
	public RoomBooking()
	{
		booking = new Booking();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public RoomState getState() {
		return state;
	}

	public void setState(RoomState state) {
		this.state = state;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
