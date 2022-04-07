package osmannyildiz.ygykNorthwindProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import osmannyildiz.ygykNorthwindProject.entities.concretes.Product;
import osmannyildiz.ygykNorthwindProject.entities.dtos.ProductWithCategoryDto;

public interface IProductDao extends JpaRepository<Product, Integer> {
	
	Product getByName(String name);
	Product getByNameAndCategoryId(String name, int categoryId);
	List<Product> getAllByNameOrCategoryId(String name, int categoryId);
	List<Product> getAllByCategoryIdIn(List<Integer> categoryIds);
	List<Product> getAllByNameContains(String nameSubstring);
	List<Product> getAllByNameStartsWith(String nameStart);
	
	@Query("from Product where name=:name and categoryId=:categoryId")
	List<Product> getAllByNameAndCategoryIdButWithQuery(String name, int categoryId);
	
	@Query("select new osmannyildiz.ygykNorthwindProject.entities.dtos.ProductWithCategoryDto(P.id, P.name, C.name) from Category C inner join C.products P")
	List<ProductWithCategoryDto> getAllProductsWithCategory();
	
	List<Product> getAllByOrderByNameAsc();
	List<Product> getAllByOrderByNameDesc();

}
