package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
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

	@Override
	public Product getProductByDisplayInfoId(int displayInfoId) {
		return productDao.getProductByDisplayInfoId(displayInfoId);
	}

	@Override
	public List<ProductImage> getProductImages(int id) {
		return productDao.getProductImages(id);
	}

	@Override
	public List<DisplayInfoImage> getDisplayInfoImages(int displayInfoId) {
		return productDao.getDisplayInfoImages(displayInfoId);
	}

	@Override
	public List<ProductPrice> getProductPrices(int id) {
		return productDao.getProductPrices(id);
	}

}
