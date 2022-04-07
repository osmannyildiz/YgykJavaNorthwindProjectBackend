package osmannyildiz.ygykNorthwindProject.business.abstracts;

import java.util.List;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.coreProject.utilities.results.Result;
import osmannyildiz.ygykNorthwindProject.entities.concretes.Product;
import osmannyildiz.ygykNorthwindProject.entities.dtos.ProductWithCategoryDto;

public interface IProductService {
	
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAll(int pageNum, int pageSize);
	DataResult<List<Product>> getAllWithSortingByName(boolean descending);
	
	DataResult<Product> add(Product product);
	
	DataResult<Product> getById(int id);
	DataResult<Product> getByName(String name);
	DataResult<Product> getByNameAndCategoryId(String name, int categoryId);
	DataResult<List<Product>> getAllByNameOrCategoryId(String name, int categoryId);
	DataResult<List<Product>> getAllByCategoryIdIn(List<Integer> categoryIds);
	DataResult<List<Product>> getAllByNameContains(String nameSubstring);
	DataResult<List<Product>> getAllByNameStartsWith(String nameStart);
	
	DataResult<List<Product>> getAllByNameAndCategoryIdButWithQuery(String name, int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getAllProductsWithCategory();
	
}
