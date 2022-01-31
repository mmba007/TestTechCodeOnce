package fr.codeonce.testTech.service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.codeonce.testTech.DTO.CategoryDTO;
import fr.codeonce.testTech.mapper.CategoryMapper;
import fr.codeonce.testTech.model.Category;
import fr.codeonce.testTech.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	CategoryMapper categoryMapper;

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
 
	@Override
	@Transactional
	public String createCategory(CategoryDTO categoryDTO) throws SQLException {
		log.info("Creating category ...");
		Category savedCateg = categoryRepo.save(categoryMapper.toBO(categoryDTO));
		if (savedCateg != null) {
			log.info("Category with id "+savedCateg.getCategoryId()+" created successfully");
			return savedCateg.getCategoryId();
		}
		log.error("Error while creating category !!");
		throw new SQLException("Could not create Category !!");
	}

	@Override
	public List<CategoryDTO> findAll() {
		log.info("Fetching all categories ...");
		return categoryRepo.findAll().stream().map(c -> categoryMapper.toDTO(c)).collect(Collectors.toList());
	}

	@Override
	public void deleteAll() {
		log.info("Deleting all categories ...");
		categoryRepo.deleteAll();
	}

}
