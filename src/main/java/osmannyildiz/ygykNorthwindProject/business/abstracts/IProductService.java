package osmannyildiz.ygykNorthwindProject.business.abstracts;

import java.util.List;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.coreProject.utilities.results.Result;
import osmannyildiz.ygykNorthwindProject.entities.concretes.Product;

public interface IProductService {
	
	DataResult<List<Product>> getAll();
	Result add(Product product);
	
}
