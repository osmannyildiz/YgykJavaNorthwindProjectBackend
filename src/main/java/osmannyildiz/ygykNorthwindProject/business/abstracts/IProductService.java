package osmannyildiz.ygykNorthwindProject.business.abstracts;

import java.util.List;

import osmannyildiz.ygykNorthwindProject.entities.concretes.Product;

public interface IProductService {
	
	List<Product> getAll();
	
}
