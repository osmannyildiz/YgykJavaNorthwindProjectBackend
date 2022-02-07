package osmannyildiz.ygykNorthwindProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.coreProject.utilities.results.Result;
import osmannyildiz.coreProject.utilities.results.SuccessDataResult;
import osmannyildiz.coreProject.utilities.results.SuccessResult;
import osmannyildiz.ygykNorthwindProject.business.abstracts.IProductService;
import osmannyildiz.ygykNorthwindProject.dataAccess.abstracts.IProductDao;
import osmannyildiz.ygykNorthwindProject.entities.concretes.Product;
import osmannyildiz.ygykNorthwindProject.entities.dtos.ProductWithCategoryDto;

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
	public DataResult<List<Product>> getAll(int pageNum, int pageSize) {
		Pageable pageable = PageRequest.of(pageNum-1, pageSize);
		return new SuccessDataResult<List<Product>>(
			productDao.findAll(pageable).getContent(), 
			"Ürünler listelendi."
		);
	}

	@Override
	public DataResult<List<Product>> getAllWithSortingByName(boolean descending) {
		Sort.Direction direction = Sort.Direction.ASC;
		if (descending)
			direction = Sort.Direction.DESC;
		
		Sort sort = Sort.by(direction, "name");
		return new SuccessDataResult<List<Product>>(
			productDao.findAll(sort), 
			"Ürünler listelendi."
		);
	}

	@Override
	public DataResult<Product> add(Product product) {
		return new SuccessDataResult<Product>(productDao.save(product), "Ürün eklendi.");
	}

	@Override
	public DataResult<Product> getByName(String name) {
		return new SuccessDataResult<Product>(productDao.getByName(name), "Ürün getirildi.");
	}

	@Override
	public DataResult<Product> getByNameAndCategoryId(String name, int categoryId) {
		return new SuccessDataResult<Product>(productDao.getByNameAndCategoryId(name, categoryId), "Ürün getirildi.");
	}

	@Override
	public DataResult<List<Product>> getByNameOrCategoryId(String name, int categoryId) {
		return new SuccessDataResult<List<Product>>(productDao.getByNameOrCategoryId(name, categoryId), "Ürünler listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categoryIds) {
		return new SuccessDataResult<List<Product>>(productDao.getByCategoryIdIn(categoryIds), "Ürünler listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByNameContains(String nameSubstring) {
		return new SuccessDataResult<List<Product>>(productDao.getByNameContains(nameSubstring), "Ürünler listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByNameStartsWith(String nameStart) {
		return new SuccessDataResult<List<Product>>(productDao.getByNameStartsWith(nameStart), "Ürünler listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategoryIdButWithQuery(String name, int categoryId) {
		return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategoryIdButWithQuery(name, categoryId), "Ürünler listelendi.");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductsWithCategory() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(productDao.getProductsWithCategory(), "Ürünler kategorileriyle listelendi.");
	}
	
}
