package kr.or.connect.reservation.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	
	@Autowired
	private CategoryService categoryService;
	
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
		List<Product> ProductList = new ArrayList<Product>();
		
		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("totalCount", );
//		map.put("productCount", value);
//		map.put("products", value);
		return map;
	}
	
	@ApiOperation(value="프로모션 목록 구하기")
	@ApiResponses({//Response Message에 대한 Swagger설명
		@ApiResponse(code=200,message="OK"),
		@ApiResponse(code=500,message="Exception")
	})
	@GetMapping("/promotions")
	public List<Promotion> promotionList(){
		List<Promotion> promotionList = new ArrayList<Promotion>();
		
		return promotionList;
	}
	
	@ApiOperation(value="전시정보 구하기")
	@ApiResponses({//Response Message에 대한 Swagger설명
		@ApiResponse(code=200,message="OK"),
		@ApiResponse(code=500,message="Exception")
	})
	@GetMapping("/displayinfos/{displayId}")
	public DisplayInfo displayInfo(@PathVariable(name="displayId")int displayId){
		DisplayInfo displayInfo = new DisplayInfo();
		
		return displayInfo;
	}
	
	@ApiOperation(value="댓글 목록 구하기")
	@ApiResponses({//Response Message에 대한 Swagger설명
		@ApiResponse(code=200,message="OK"),
		@ApiResponse(code=500,message="Exception")
	})
	@GetMapping("/comments")
	public List<ReservationUserComment> commentList(@RequestParam(name="productId", required=false)int productId,@RequestParam(name="start", required=false)int start){
		List<ReservationUserComment> commentList = new ArrayList<ReservationUserComment>();
		
		return commentList;
	}

}
