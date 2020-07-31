package kr.or.connect.reservation.controller.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.CommentService;
import kr.or.connect.reservation.service.ProductService;
import kr.or.connect.reservation.service.PromotionService;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PromotionService promotionService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ReservationService reservationService;
	
	@ApiOperation(value="카테고리 목록 구하기")
	@ApiResponses({//Response Message에 대한 Swagger설명
		@ApiResponse(code=200,message="OK"),
		@ApiResponse(code=500,message="Exception")
	})
	@GetMapping("/categories")
	public Map<String,Object> categoryList() {
		List<Category> categoryList = categoryService.getCategories();
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("size", categoryList.size());
		map.put("items", categoryList);
		
		return map;
	}
	
	@ApiOperation(value="상품 목록 구하기")
	@ApiResponses({//Response Message에 대한 Swagger설명
		@ApiResponse(code=200,message="OK"),
		@ApiResponse(code=500,message="Exception")
	})
	@GetMapping("/displayinfos")
	public Map<String,Object> displayInfoList(@RequestParam(name="categoryId",required=false,defaultValue="0")int categoryId, @RequestParam(name="start", required=false, defaultValue="0") int start){
		List<Product> ProductList = productService.getProducts(categoryId,start);
		int totalCount = productService.getCount(categoryId);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("totalCount", totalCount);
		map.put("productCount", ProductList.size());
		map.put("products", ProductList);
		return map;
	}
	
	@ApiOperation(value="프로모션 목록 구하기")
	@ApiResponses({//Response Message에 대한 Swagger설명
		@ApiResponse(code=200,message="OK"),
		@ApiResponse(code=500,message="Exception")
	})
	@GetMapping("/promotions")
	public Map<String,Object> promotionList(){
		List<Promotion> promotionList = promotionService.getPromotions();
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("size", promotionList.size());
		map.put("items", promotionList);
		
		return map;
	}
	
	@ApiOperation(value="전시정보 구하기")
	@ApiResponses({//Response Message에 대한 Swagger설명
		@ApiResponse(code=200,message="OK"),
		@ApiResponse(code=500,message="Exception")
	})
	@GetMapping("/displayinfos/{displayInfoId}")
	public  Map<String,Object> displayInfo(@PathVariable(name="displayInfoId")int displayInfoId){
		Product product = productService.getProductByDisplayInfoId(displayInfoId);
		List<ProductImage> productImageList = productService.getProductImages(product.getId());
		List<DisplayInfoImage> displayInfoImageList = productService.getDisplayInfoImages(displayInfoId);
		List<ProductPrice> productPriceList = productService.getProductPrices(product.getId());
		int avgScore = commentService.getAvgScore(product.getId());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("product", product);
		map.put("productImages", productImageList);
		map.put("displayInfoImages", displayInfoImageList);
		map.put("avgScore", avgScore);
		map.put("productPrices", productPriceList);
		
		return map;
	}
	
	@ApiOperation(value="댓글 목록 구하기")
	@ApiResponses({//Response Message에 대한 Swagger설명
		@ApiResponse(code=200,message="OK"),
		@ApiResponse(code=500,message="Exception")
	})
	@GetMapping("/comments")
	public Map<String,Object> commentList(@RequestParam(name="productId", required=false)int productId,@RequestParam(name="start", required=false)int start){
		List<ReservationUserComment> commentList = commentService.getComments(productId,start);
		int totalCount = commentService.getCount(productId);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("totalCount", totalCount);
		map.put("commentCount", commentList.size());
		map.put("reservationUserComments", commentList);
		
		return map;
	}
	
	@ApiOperation(value="예약 등록하기")
	@ApiResponses({//Response Message에 대한 Swagger설명
		@ApiResponse(code=200,message="OK"),
		@ApiResponse(code=500,message="Exception")
	})
	@PostMapping("/reservationRegister")
	public ReservationInfo reservationRegister(@RequestBody Reservation reservation) throws ParseException{
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy.MM.dd");
		reservation.setReservationDate(transFormat.parse(reservation.getReservationYearMonthDay()));

		int reservationInfoId = reservationService.reservationRegister(reservation);
		
		ReservationInfo reservationInfo = reservationService.getReservationInfos(reservationInfoId);
		
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("reservationInfo", reservationInfo);
		
		List<ReservationInfo> list = new ArrayList<ReservationInfo>();
		list.add(reservationInfo);
		
		return reservationInfo;
	}

}
