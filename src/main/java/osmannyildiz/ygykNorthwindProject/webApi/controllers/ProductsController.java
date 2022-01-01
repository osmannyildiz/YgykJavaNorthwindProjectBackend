package osmannyildiz.ygykNorthwindProject.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Product> getAll() {
		return productService.getAll();
	}

}
