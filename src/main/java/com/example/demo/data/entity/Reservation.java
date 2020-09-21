package com.example.demo.data.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class Reservation {

	@Id
	@Column(name="RESERVATION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long resId;
	
	@Column(name="ROOM_ID")
	private long roomId;
	
	@Column(name="GUEST_ID")
	private long guestId;
	
	@Column(name="RES_DATE")
	private Date reservationDate;

	public long getResId() {
		return resId;
	}

	public void setResId(long resId) {
		this.resId = resId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public long getGuestId() {
		return guestId;
	}

	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date resDate) {
		this.reservationDate = resDate;
	}
	
	
}
