package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.ReservationInfo;

public interface ReservationService {

	int reservationRegister(Reservation reservation);

	ReservationInfo getReservationInfos(int reservationInfoId);
	
}
