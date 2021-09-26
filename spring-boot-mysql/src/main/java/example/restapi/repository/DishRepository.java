package example.restapi.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import example.restapi.model.*;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

	public Page<Dish> findByName(String name,Pageable pageable);

	  //public Dish findOne(long id);
	  
	  public Page<Dish> findAll(Pageable pageable);
	  
}