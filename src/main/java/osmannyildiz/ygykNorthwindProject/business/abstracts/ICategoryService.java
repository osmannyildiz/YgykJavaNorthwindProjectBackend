package osmannyildiz.ygykNorthwindProject.business.abstracts;

import java.util.List;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.ygykNorthwindProject.entities.concretes.Category;

public interface ICategoryService {
	
	DataResult<List<Category>> getAll();
	DataResult<List<Category>> getAllWithSortingByName(boolean descending);
	DataResult<Category> getById(int id);

}
