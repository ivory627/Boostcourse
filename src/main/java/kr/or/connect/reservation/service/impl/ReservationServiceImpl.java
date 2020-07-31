package kr.or.connect.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	ReservationDao reservationDao;
	
	@Override
	public int reservationRegister(Reservation reservation) {
		return reservationDao.reservationRegister(reservation);
	}

	@Override
	public ReservationInfo getReservationInfos(int reservationInfoId) {
		ReservationInfo reservationInfo = reservationDao.getReservationInfos(reservationInfoId);
		reservationInfo.setPrices(reservationDao.getPrices(reservationInfoId));
		return reservationInfo;
	}

}
