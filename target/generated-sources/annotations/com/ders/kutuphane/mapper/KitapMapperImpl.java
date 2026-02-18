package com.ders.kutuphane.mapper;

import com.ders.kutuphane.dto.KitapDTO;
import com.ders.kutuphane.entity.Category;
import com.ders.kutuphane.entity.Kitap;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-18T22:06:43+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class KitapMapperImpl implements KitapMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public KitapDTO entityToDto(Kitap kitap) {
        if ( kitap == null ) {
            return null;
        }

        KitapDTO kitapDTO = new KitapDTO();

        kitapDTO.setCategoryId( kitapCategoryId( kitap ) );
        kitapDTO.setId( kitap.getId() );
        kitapDTO.setCategory( categoryMapper.toDTO( kitap.getCategory() ) );
        kitapDTO.setSayfaSayisi( kitap.getSayfaSayisi() );
        kitapDTO.setIsim( kitap.getIsim() );
        kitapDTO.setYazar( kitap.getYazar() );

        return kitapDTO;
    }

    @Override
    public Kitap dtoToEntity(KitapDTO kitapDto) {
        if ( kitapDto == null ) {
            return null;
        }

        Kitap kitap = new Kitap();

        kitap.setCategory( categoryMapper.toEntity( kitapDto.getCategory() ) );
        kitap.setIsim( kitapDto.getIsim() );
        kitap.setYazar( kitapDto.getYazar() );
        kitap.setSayfaSayisi( kitapDto.getSayfaSayisi() );

        return kitap;
    }

    private Long kitapCategoryId(Kitap kitap) {
        if ( kitap == null ) {
            return null;
        }
        Category category = kitap.getCategory();
        if ( category == null ) {
            return null;
        }
        long id = category.getId();
        return id;
    }
}
