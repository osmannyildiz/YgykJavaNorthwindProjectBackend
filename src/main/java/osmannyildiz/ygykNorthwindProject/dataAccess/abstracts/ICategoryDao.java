package osmannyildiz.ygykNorthwindProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import osmannyildiz.ygykNorthwindProject.entities.concretes.Category;

public interface ICategoryDao extends JpaRepository<Category, Integer> {

}
