package osmannyildiz.ygykNorthwindProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import osmannyildiz.ygykNorthwindProject.business.abstracts.IProductService;
import osmannyildiz.ygykNorthwindProject.dataAccess.abstracts.IProductDao;
import osmannyildiz.ygykNorthwindProject.entities.concretes.Product;

@Service
public class ProductManager implements IProductService {
	
	private IProductDao productDao;

	@Autowired
	public ProductManager(IProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
		return productDao.findAll();
	}
	
}
