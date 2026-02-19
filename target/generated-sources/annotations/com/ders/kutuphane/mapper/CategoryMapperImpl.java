package com.ders.kutuphane.mapper;

import com.ders.kutuphane.dto.CategoryDTO;
import com.ders.kutuphane.entity.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-19T15:20:58+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO toDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setIsim( category.getIsim() );

        return categoryDTO;
    }

    @Override
    public Category toEntity(CategoryDTO categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoryDto.getId() != null ) {
            category.setId( categoryDto.getId() );
        }
        category.setIsim( categoryDto.getIsim() );

        return category;
    }
}
