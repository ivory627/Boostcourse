package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;

public interface ProductService {
	public static final Integer LIMIT = 4;
	List<Product> getProducts(Integer categoryId, Integer start);
	int getCount(Integer categoryId);
	Product getProductByDisplayInfoId(int displayInfoId);
	List<ProductImage> getProductImages(int id);
	List<DisplayInfoImage> getDisplayInfoImages(int displayInfoId);
	List<ProductPrice> getProductPrices(int id);
}
