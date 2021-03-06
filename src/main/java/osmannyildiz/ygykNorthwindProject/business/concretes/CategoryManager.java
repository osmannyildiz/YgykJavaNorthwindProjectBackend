package osmannyildiz.ygykNorthwindProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.coreProject.utilities.results.SuccessDataResult;
import osmannyildiz.ygykNorthwindProject.business.abstracts.ICategoryService;
import osmannyildiz.ygykNorthwindProject.dataAccess.abstracts.ICategoryDao;
import osmannyildiz.ygykNorthwindProject.entities.concretes.Category;

@Service
public class CategoryManager implements ICategoryService {
	
	private ICategoryDao categoryDao;

	@Autowired
	public CategoryManager(ICategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public DataResult<List<Category>> getAll() {
		return new SuccessDataResult<List<Category>>(categoryDao.findAll(), "Kategoriler listelendi.");
	}
	
	@Override
	public DataResult<List<Category>> getAllWithSortingByName(boolean descending) {
		if (descending)
			return new SuccessDataResult<List<Category>>(
				categoryDao.getAllByOrderByNameDesc(), 
				"Kategoriler azalan isim sırasına göre listelendi."
			);
		else
			return new SuccessDataResult<List<Category>>(
				categoryDao.getAllByOrderByNameAsc(), 
				"Kategoriler artan isim sırasına göre listelendi."
			);
	}
	
	@Override
	public DataResult<Category> getById(int id) {
		Category entity = categoryDao.findById(id).get();
		return new SuccessDataResult<Category>(entity, "Kategori getirildi.");
	}

}
