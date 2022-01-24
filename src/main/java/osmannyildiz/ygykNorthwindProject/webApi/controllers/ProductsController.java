package osmannyildiz.ygykNorthwindProject.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.coreProject.utilities.results.Result;
import osmannyildiz.coreProject.utilities.results.SuccessResult;
import osmannyildiz.ygykNorthwindProject.business.abstracts.IProductService;
import osmannyildiz.ygykNorthwindProject.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
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
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		DataResult<Product> addResult = productService.add(product); 
		return new SuccessResult(addResult.getMessage());
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

}
