package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ReservationUserComment;

public interface CommentService {
	public static final Integer LIMIT = 5;
	public List<ReservationUserComment> getComments(Integer productId, Integer start);
	public int getCount(Integer productId);
	public int getAvgScore(int id);

}
