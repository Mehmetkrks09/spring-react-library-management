package com.ders.kutuphane.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ders.kutuphane.dto.KitapDTO;
import com.ders.kutuphane.entity.Kitap;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface KitapMapper {
	
	@Mapping(source = "category.id", target = "categoryId")
	KitapDTO entityToDto(Kitap kitap);
	
	@Mapping(target = "id", ignore = true)
	Kitap dtoToEntity(KitapDTO kitapDto);

}
