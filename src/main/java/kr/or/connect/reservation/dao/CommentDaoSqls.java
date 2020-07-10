package kr.or.connect.reservation.dao;

public class CommentDaoSqls {
	public static final String SELECT_COMMENTS= "select c.id, c.product_id, c.reservation_info_id, c.score, u.email as reservation_email, c.comment, c.create_date, c.modify_date " + 
			"from reservation_user_comment as c " + 
			"join user as u " + 
			"on c.user_id = u.id " +
			"where c.product_id = :productId " + 
			"order by c.id desc limit :start,:limit";
	
	public static final String COUNT = "select count(*) from reservation_user_comment " + 
			"where product_id = :productId";
	
	public static final String AVG_SCORE = "select avg(score) from reservation_user_comment " + 
			"where product_id = :id";
}
