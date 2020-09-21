package com.example.demo.business.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.domain.RoomReservation;
import com.example.demo.data.entity.Guest;
import com.example.demo.data.entity.Reservation;
import com.example.demo.data.entity.Room;
import com.example.demo.data.entity.repository.GuestRepository;
import com.example.demo.data.entity.repository.ReservationRepository;
import com.example.demo.data.entity.repository.RoomRepository;

@Service
public class ReservationService {

	private final RoomRepository roomRepository;// to work, it need this dependencies
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;

	@Autowired
	public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository,
			ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}
	
	public List<RoomReservation> getRoomReservationsForDate(Date date) {
		
		Iterable<Room> rooms = this.roomRepository.findAll();
		Map<Long, RoomReservation> roomReservationMap = new HashMap<Long, RoomReservation>();
		rooms.forEach(room -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getRoomId());
			roomReservation.setRoomName(room.getRoomName());
			roomReservation.setRoomNumber(room.getRoomNumber());
			roomReservationMap.put(room.getRoomId(), roomReservation);
		});
		Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
		reservations.forEach(reservation -> {
			RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
			roomReservation.setDate(date);
			Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
			roomReservation.setFirstName(guest.getFirstName());
			roomReservation.setLastName(guest.getLastName());
			roomReservation.setGuestId(guest.getGuestId());
		});
		List<RoomReservation> roomReservations = new ArrayList<>();
		for(Long id: roomReservationMap.keySet()) {
			roomReservations.add(roomReservationMap.get(id));
		}
		return roomReservations;
	}
	
	public List<Guest> getAllGuests() {
		
		Iterable<Guest> guests = this.guestRepository.findAll();
		List<Guest> listGuests= new ArrayList<>();
		guests.forEach(listGuests::add);
		listGuests.sort(new SortGuestByName());	
		return listGuests;
		
	}
	
}

class SortGuestByName implements Comparator<Guest>{

	@Override
	public int compare(Guest o1, Guest o2) {
		
		if (o1.getLastName() == o2.getLastName()) {
			
			return o1.getFirstName().compareTo(o2.getFirstName());
			
		}
		
		return o1.getLastName().compareTo(o2.getLastName());
		
	}
	
}
