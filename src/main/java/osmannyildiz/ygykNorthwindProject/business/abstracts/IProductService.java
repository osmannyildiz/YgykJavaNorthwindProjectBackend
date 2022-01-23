package osmannyildiz.ygykNorthwindProject.business.abstracts;

import java.util.List;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.coreProject.utilities.results.Result;
import osmannyildiz.ygykNorthwindProject.entities.concretes.Product;

public interface IProductService {
	
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAll(int pageNum, int pageSize);
	DataResult<List<Product>> getAllWithSortingByName(boolean descending);
	
	Result add(Product product);
	
	DataResult<Product> getByName(String name);
	DataResult<Product> getByNameAndCategoryId(String name, int categoryId);
	DataResult<List<Product>> getByNameOrCategoryId(String name, int categoryId);
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categoryIds);
	DataResult<List<Product>> getByNameContains(String nameSubstring);
	DataResult<List<Product>> getByNameStartsWith(String nameStart);
	
	DataResult<List<Product>> getByNameAndCategoryIdButWithQuery(String name, int categoryId);
	
}
