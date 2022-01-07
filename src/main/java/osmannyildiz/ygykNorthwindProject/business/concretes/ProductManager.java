package osmannyildiz.ygykNorthwindProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import osmannyildiz.ygykNorthwindProject.business.abstracts.IProductService;
import osmannyildiz.ygykNorthwindProject.core.utilities.results.DataResult;
import osmannyildiz.ygykNorthwindProject.core.utilities.results.Result;
import osmannyildiz.ygykNorthwindProject.core.utilities.results.SuccessDataResult;
import osmannyildiz.ygykNorthwindProject.core.utilities.results.SuccessResult;
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
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(productDao.findAll(), "Ürünler listelendi.");
	}

	@Override
	public Result add(Product product) {
		productDao.save(product);
		return new SuccessResult("Ürün eklendi.");
	}
	
}
