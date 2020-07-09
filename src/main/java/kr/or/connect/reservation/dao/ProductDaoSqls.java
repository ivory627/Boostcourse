package kr.or.connect.reservation.dao;

public class ProductDaoSqls {
	public static final String SELECT_WHERE_CATEGORY = "select p.id, p.category_id, d.id as display_info_id, c.name, p.description, p.content, p.event," + 
			"d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email, p.create_date, p.modify_date, (select file_id from product_image where p.id = product_id and type = 'ma') as file_id " + 
			"from product as p " + 
			"left join category as c " + 
			"on p.category_id = c.id " + 
			"join display_info as d " + 
			"on p.id = d.product_id " +
			"where category_id = :categoryId " +
			"order by p.id limit :start, :limit";
	
	public static final String SELECT_ALL = "select p.id, p.category_id, d.id as display_info_id, c.name, p.description, p.content, p.event," + 
			"d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email, p.create_date, p.modify_date, (select file_id from product_image where p.id = product_id and type = 'ma') as file_id " + 
			"from product as p " + 
			"left join category as c " + 
			"on p.category_id = c.id " + 
			"join display_info as d " + 
			"on p.id = d.product_id " +
			"order by p.id limit :start, :limit";
	
	public static final String COUNT = "select count(*) from display_info as d " + 
			"join product as p " + 
			"on p.id = d.product_id " + 
			"where category_id= :categoryId";
	public static final String COUNT_ALL = "select count(*) from display_info";
}
