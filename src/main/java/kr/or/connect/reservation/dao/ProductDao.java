package kr.or.connect.reservation.dao;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;

import static kr.or.connect.reservation.dao.ProductDaoSqls.*;

@Repository
public class ProductDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	private RowMapper<ProductImage> rowMapperProductImage = BeanPropertyRowMapper.newInstance(ProductImage.class);
	private RowMapper<DisplayInfoImage> rowMapperDisplayInfoImage = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	private RowMapper<ProductPrice> rowMapperProductPrice = BeanPropertyRowMapper.newInstance(ProductPrice.class);

    public ProductDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("product")
                .usingGeneratedKeyColumns("id");
    }

	public List<Product> getProducts(Integer categoryId,Integer start,Integer limit) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("start", start);
		params.put("limit", limit);
		params.put("categoryId", categoryId);
		return jdbc.query(SELECT_WHERE_CATEGORY, params, rowMapper);
	}

	public List<Product> getAllProducts(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_ALL, params, rowMapper);
	}

	public int getCount(Integer categoryId) {
		Map<String,?> params = Collections.singletonMap("categoryId", categoryId);
		return jdbc.queryForObject(COUNT, params, Integer.class);
	}

	public int getCountAll() {
		return jdbc.queryForObject(COUNT_ALL, Collections.emptyMap(), Integer.class);
	}

	public Product getProductByDisplayInfoId(int displayInfoId) {
		Map<String,?> params = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbc.queryForObject(SELECT_WHERE_DISPLAYINFOID, params, rowMapper);
	}

	public List<ProductImage> getProductImages(int id) {
		Map<String,?> params = Collections.singletonMap("id", id);
		return jdbc.query(SELECT_PRODUCT_IMAGES, params, rowMapperProductImage);
	}

	public List<DisplayInfoImage> getDisplayInfoImages(int displayInfoId) {
		Map<String, ?> params = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbc.query(SELECT_DISPLAY_INFO_IMAGES, params, rowMapperDisplayInfoImage);
	}

	public List<ProductPrice> getProductPrices(int id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.query(SELECT_PRODUCT_PRICES, params, rowMapperProductPrice);
	}

}
