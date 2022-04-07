package osmannyildiz.ygykNorthwindProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.coreProject.utilities.results.ErrorDataResult;
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
		if (descending)
			return new SuccessDataResult<List<Product>>(
				productDao.getAllByOrderByNameDesc(), 
				"Ürünler azalan isim sırasına göre listelendi."
			);
		else
			return new SuccessDataResult<List<Product>>(
				productDao.getAllByOrderByNameAsc(), 
				"Ürünler artan isim sırasına göre listelendi."
			);
	}

	@Override
	public DataResult<Product> add(Product product) {
		if (product.getName().equalsIgnoreCase("bitcoin")) {
			return new ErrorDataResult<Product>("Marketimizde Bitcoin satışı yapılmasına izin verilmemektedir. Anlayışınız için teşekkür ederiz.");
		}
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
	public DataResult<List<Product>> getAllByNameOrCategoryId(String name, int categoryId) {
		return new SuccessDataResult<List<Product>>(productDao.getAllByNameOrCategoryId(name, categoryId), "Ürünler listelendi.");
	}

	@Override
	public DataResult<List<Product>> getAllByCategoryIdIn(List<Integer> categoryIds) {
		return new SuccessDataResult<List<Product>>(productDao.getAllByCategoryIdIn(categoryIds), "Ürünler listelendi.");
	}

	@Override
	public DataResult<List<Product>> getAllByNameContains(String nameSubstring) {
		return new SuccessDataResult<List<Product>>(productDao.getAllByNameContains(nameSubstring), "Ürünler listelendi.");
	}

	@Override
	public DataResult<List<Product>> getAllByNameStartsWith(String nameStart) {
		return new SuccessDataResult<List<Product>>(productDao.getAllByNameStartsWith(nameStart), "Ürünler listelendi.");
	}

	@Override
	public DataResult<List<Product>> getAllByNameAndCategoryIdButWithQuery(String name, int categoryId) {
		return new SuccessDataResult<List<Product>>(productDao.getAllByNameAndCategoryIdButWithQuery(name, categoryId), "Ürünler listelendi.");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getAllProductsWithCategory() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(productDao.getAllProductsWithCategory(), "Ürünler kategorileriyle listelendi.");
	}

	@Override
	public DataResult<Product> getById(int id) {
		Product entity = productDao.findById(id).get();
		return new SuccessDataResult<Product>(entity, "Ürün getirildi.");
	}
	
}
