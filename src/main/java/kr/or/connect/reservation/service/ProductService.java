package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Product;

public interface ProductService {
	public static final Integer LIMIT = 4;
	List<Product> getProducts(Integer categoryId, Integer start);
	int getCount(Integer categoryId);
}
