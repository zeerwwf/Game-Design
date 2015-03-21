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
@Table(name = "booking")
public class Booking implements Serializable {

	private static final long serialVersionUID = 6640560833621931831L;

	public enum BookingState
	{
		WAITING_VALIDATION,
		WAITING_DEPOSIT,
		VALIDATED,
		ENDED,
		ARCHIVED
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	private Date dateArrival;
	private Date dateDeparture;
	private BookingState state;
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "ESTABLISHMENT_ID")
	private Establishment establishment;
	
	public Booking()
	{
		client = new Client();
		establishment = new Establishment();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateArrival() {
		return dateArrival;
	}

	public void setDateArrival(Date dateArrival) {
		this.dateArrival = dateArrival;
	}

	public Date getDateDeparture() {
		return dateDeparture;
	}

	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	public BookingState getState() {
		return state;
	}

	public void setState(BookingState state) {
		this.state = state;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
}
