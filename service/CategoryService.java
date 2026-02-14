package com.ders.kutuphane.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ders.kutuphane.dto.CategoryDTO;
import com.ders.kutuphane.entity.Category;
import com.ders.kutuphane.mapper.CategoryMapper;
import com.ders.kutuphane.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryMapper categoryMapper;
	
	public CategoryDTO save(CategoryDTO dto) {
		
		Category category = categoryMapper.toEntity(dto);
		category=categoryRepository.save(category);
		return categoryMapper.toDTO(category);

}
	public List<CategoryDTO> getAll() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

}
