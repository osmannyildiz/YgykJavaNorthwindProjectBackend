package osmannyildiz.ygykNorthwindProject.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.coreProject.utilities.results.ErrorResult;
import osmannyildiz.coreProject.utilities.results.Result;
import osmannyildiz.coreProject.utilities.results.SuccessResult;
import osmannyildiz.ygykNorthwindProject.business.abstracts.IProductService;
import osmannyildiz.ygykNorthwindProject.entities.concretes.Product;
import osmannyildiz.ygykNorthwindProject.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
	
	private IProductService productService;
	
	@Autowired
	public ProductsController(IProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Product>> getAll() {
		return productService.getAll();
	}
	
	@GetMapping("/getAllWithPagination")
	public DataResult<List<Product>> getAllWithPagination(@RequestParam int pageNum, @RequestParam int pageSize) {
		return productService.getAll(pageNum, pageSize);
	}
	
	@GetMapping("/getAllWithSortingByName")
	public DataResult<List<Product>> getAllWithSortingByName(@RequestParam boolean descending) {
		return productService.getAllWithSortingByName(descending);
	}
	
	@GetMapping("/getById")
	public DataResult<Product> getById(@RequestParam int id) {
		return productService.getById(id);
	}
	
	@GetMapping("/getByName")
	public DataResult<Product> getByName(@RequestParam String name) {
		return productService.getByName(name);
	}
	
	@GetMapping("/getByNameAndCategoryId")
	public DataResult<Product> getByNameAndCategoryId(@RequestParam String name, @RequestParam int categoryId) {
		return productService.getByNameAndCategoryId(name, categoryId);
	}
	
	@GetMapping("/getByNameContains")
	public DataResult<List<Product>> getByNameContains(@RequestParam String nameSubstring) {
		return productService.getByNameContains(nameSubstring);
	}
	
	@GetMapping("/getProductsWithCategory")
	public DataResult<List<ProductWithCategoryDto>> getProductsWithCategory() {
		return productService.getProductsWithCategory();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		DataResult<Product> addResult = productService.add(product);
		if (!addResult.isSuccess()) {
			return new ErrorResult(addResult.getMessage());
		}
		
		return new SuccessResult(addResult.getMessage());
	}

}
