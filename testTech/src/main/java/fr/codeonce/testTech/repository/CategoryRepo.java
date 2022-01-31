package fr.codeonce.testTech.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import fr.codeonce.testTech.model.Category;

@Repository("categoryRepo")
public interface CategoryRepo extends MongoRepository<Category, String> {

	@Query(value = "{name: {$regex: ?2}}", fields = "{products: {$slice: [?0, ?1]}}")
	public Optional<Category> findByName(int skip, int limit, String name);

}
