package osmannyildiz.ygykNorthwindProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import osmannyildiz.ygykNorthwindProject.entities.concretes.Category;

public interface ICategoryDao extends JpaRepository<Category, Integer> {
	
	List<Category> getByOrderByNameAsc();
	List<Category> getByOrderByNameDesc();

}
