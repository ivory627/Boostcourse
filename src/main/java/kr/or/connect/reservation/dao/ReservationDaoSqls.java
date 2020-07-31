package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	public static final String SELECT_ALL_RESERVATIONINFO = "select id, product_id, cancel_flag, display_info_id, user_id, reservation_date, create_date, modify_date " + 
			"from reservation_info " + 
			"where id =:reservationInfoId";
	public static final String SELECT_RESERVATIONINFO_PRICE = "select id, reservation_info_id, product_price_id, count " + 
			"from reservation_info_price " + 
			"where reservation_info_id =:reservationInfoId";
}
