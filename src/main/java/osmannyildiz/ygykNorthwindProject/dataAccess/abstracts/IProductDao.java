package osmannyildiz.ygykNorthwindProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import osmannyildiz.ygykNorthwindProject.entities.concretes.Product;

public interface IProductDao extends JpaRepository<Product, Integer> {
	
	Product getByName(String name);
	Product getByNameAndCategoryId(String name, int categoryId);
	List<Product> getByNameOrCategoryId(String name, int categoryId);
	List<Product> getByCategoryIdIn(List<Integer> categoryIds);
	List<Product> getByNameContains(String nameSubstring);
	List<Product> getByNameStartsWith(String nameStart);
	
	@Query("from Product where name=:name and categoryId=:categoryId")
	List<Product> getByNameAndCategoryIdButWithQuery(String name, int categoryId);

}
