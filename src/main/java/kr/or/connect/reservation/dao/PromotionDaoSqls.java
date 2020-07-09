package kr.or.connect.reservation.dao;

public class PromotionDaoSqls {
	public static final String SELECT_PROMOTIONS = "select prom.id, prom.product_id, prod.category_id, c.name as category_name, prod.description, pi.file_id from promotion prom " + 
			"join product as prod " + 
			"on prom.product_id = prod.id " + 
			"join category as c " + 
			"on c.id = prod.category_id " + 
			"join product_image as pi " + 
			"on pi.product_id = prod.id " + 
			"where pi.type = 'ma'";
}
