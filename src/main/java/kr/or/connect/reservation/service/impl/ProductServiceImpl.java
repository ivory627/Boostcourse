package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public List<Product> getProducts(Integer categoryId,Integer start) {
		
		List<Product> productList;
		
		if(categoryId==0) { //전체조회
			productList = productDao.getAllProducts(start,LIMIT);
		}else {
			productList = productDao.getProducts(categoryId,start,LIMIT);			
		}
		return productList;
	}

	@Override
	public int getCount(Integer categoryId) {
		
		if(categoryId==0) {
			return productDao.getCountAll();
		}else {
			return productDao.getCount(categoryId);			
		}
	}

}
