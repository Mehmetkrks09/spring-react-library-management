package com.ders.kutuphane.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ders.kutuphane.dto.CategoryDTO;
import com.ders.kutuphane.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	
	CategoryDTO toDTO(Category category);
	
	@Mapping(target = "kitaplar", ignore = true)
	Category toEntity(CategoryDTO categoryDto);

}
