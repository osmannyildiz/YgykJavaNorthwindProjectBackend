package osmannyildiz.ygykNorthwindProject.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.ygykNorthwindProject.business.abstracts.ICategoryService;
import osmannyildiz.ygykNorthwindProject.entities.concretes.Category;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoriesController {
	
private ICategoryService categoryService;
	
	@Autowired
	public CategoriesController(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Category>> getAll() {
		return categoryService.getAll();
	}
	
	@GetMapping("/getAllWithSortingByName")
	public DataResult<List<Category>> getAllWithSortingByName(@RequestParam boolean descending) {
		return categoryService.getAllWithSortingByName(descending);
	}
	
	@GetMapping("/getById")
	public DataResult<Category> getById(@RequestParam int id) {
		return categoryService.getById(id);
	}

}
