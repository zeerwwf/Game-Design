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
@Table(name = "establishmentrating")
public class EstablishmentRating implements Serializable {

	private static final long serialVersionUID = -1784111362638044564L;
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	private int mark;
	private String comment;
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "ESTABLISHMENT_ID")
	private Establishment establishment;
	
	public EstablishmentRating()
	{
		setClient(new Client());
		setEstablishment(new Establishment());
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
