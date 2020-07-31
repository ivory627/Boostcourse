package kr.or.connect.reservation.dto;

import java.util.Date;
import java.util.List;

public class Reservation {
	private List<ReservationInfoPrice> prices;
	private int productId;
	private int displayInfoId;
	private String reservationYearMonthDay;
	private Date reservationDate;
	private int userId;
	
	public List<ReservationInfoPrice> getPrices() {
		return prices;
	}
	public void setPrices(List<ReservationInfoPrice> prices) {
		this.prices = prices;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public String getReservationYearMonthDay() {
		return reservationYearMonthDay;
	}
	public void setReservationYearMonthDay(String reservationYearMonthDay) {
		this.reservationYearMonthDay = reservationYearMonthDay;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	@Override
	public String toString() {
		return "Reservation [prices=" + prices + ", productId=" + productId + ", displayInfoId=" + displayInfoId
				+ ", reservationYearMonthDay=" + reservationYearMonthDay + ", reservationDate=" + reservationDate
				+ ", userId=" + userId + "]";
	}
	
	
}
