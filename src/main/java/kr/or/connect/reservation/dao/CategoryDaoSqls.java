package kr.or.connect.reservation.dao;

public class CategoryDaoSqls {
	public static final String SELECT_ALL = "select c.id,c.name,count(c.id) as count " + 
			"from category as c " + 
			"left join product as p " + 
			"on c.id = p.category_id " + 
			"group by c.id";
}
