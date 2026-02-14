package com.ders.kutuphane.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ders.kutuphane.dto.KitapDTO;
import com.ders.kutuphane.entity.Category;
import com.ders.kutuphane.entity.Kitap;
import com.ders.kutuphane.exception.CategoryNotFoundException;
import com.ders.kutuphane.exception.KitapBulunamadiException;
import com.ders.kutuphane.mapper.KitapMapper;
import com.ders.kutuphane.repository.CategoryRepository;
import com.ders.kutuphane.repository.KitapRepository;

import jakarta.transaction.Transactional;

@Service
public class KitapService {

	@Autowired
	private KitapRepository kitapRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private KitapMapper kitapMapper;

	// ----------------------------------------------------------------------------

	@Transactional
	public KitapDTO saveBook(KitapDTO dto) {

		Kitap kitap = kitapMapper.dtoToEntity(dto);

		if (dto.getCategoryId() != null) {
			Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(
					() -> new CategoryNotFoundException("ID " + dto.getCategoryId() + " olan kategori bulunamadı"));
			kitap.setCategory(category);
		}

		kitap = kitapRepository.save(kitap);
		return kitapMapper.entityToDto(kitap);
	}

	@Transactional
	public void deleteBookById(Long id) {

		if (!kitapRepository.existsById(id)) {

			throw new RuntimeException("Silmek istediğiniz kitap bulunamadı!");
		}

		kitapRepository.deleteById(id);

	}

	public List<KitapDTO> getAllBooks() {
		List<Kitap> kitaplar = kitapRepository.findAll();

		return kitaplar.stream().map(kitapMapper::entityToDto).collect(Collectors.toList());
	}

	public List<KitapDTO> getByCategoryId( Long categoryId) {

		return kitapRepository.findByCategoryId(categoryId).stream().map(kitapMapper::entityToDto)
				.collect(Collectors.toList());
	}

	public KitapDTO getBook(Long id) {
		Kitap kitap = kitapRepository.findById(id).orElseThrow(
				() -> new KitapBulunamadiException("Aradığınız " + id + " numaralı kitap kütüphanede bulunamadı!"));
		return kitapMapper.entityToDto(kitap);
	}

	@Transactional
	public KitapDTO updateBook(Long id, KitapDTO kitapDto) {
		Kitap mevcutKitap = kitapRepository.findById(id).orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

		mevcutKitap.setIsim(kitapDto.getIsim());
		mevcutKitap.setYazar(kitapDto.getYazar());
		mevcutKitap.setSayfaSayisi(kitapDto.getSayfaSayisi());

		Kitap güncellenenKitap = kitapRepository.save(mevcutKitap);
		return kitapMapper.entityToDto(güncellenenKitap);

	}

}
