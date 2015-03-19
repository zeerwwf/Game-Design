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
@Table(name = "room")
public class Room implements Serializable {
	
	private static final long serialVersionUID = -7961946400493198308L;

	public enum RoomType
	{
		SINGLE_ROOM,
		DOUBLE_ROOM,
		TRIPLE_ROOM
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	private String title;
	private RoomType roomType;
	@ManyToOne
	@JoinColumn(name = "ESTABLISHMENT_ID")
	private Establishment establishment;
	
	public Room()
	{
		establishment = new Establishment();
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
	
	public RoomType getRoomType() {
		return roomType;
	}
	
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	public Establishment getEstablishment() {
		return establishment;
	}
	
	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
}
