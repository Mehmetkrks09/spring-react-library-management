package com.ders.kutuphane.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ders.kutuphane.dto.KitapDTO;
import com.ders.kutuphane.service.KitapService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/kitaplar")
public class KitapController {

	@Autowired
	private KitapService kitapService;
	
	@GetMapping
	public List<KitapDTO> tumunuGetir() {
		return kitapService.tumKitaplarıGetir();
	}
	
	@GetMapping("/kategori/{categoryId}")
	public ResponseEntity<List<KitapDTO>> getByCategoryId(@PathVariable Long categoryId){
		
		List<KitapDTO> kitaplar = kitapService.getByCategoryId(categoryId);
		return ResponseEntity.ok(kitaplar);
	}
	
	
	@GetMapping("/{id}")
	public KitapDTO kitapGetir(@PathVariable Long id) {
		return kitapService.kitapGetir(id);
	}
	
	@PostMapping
	public KitapDTO yeniKitapEkle(@Valid @RequestBody KitapDTO kitapDto) {
		return kitapService.kitapKaydet(kitapDto);
		
	}
	
	@PutMapping("/{id}")
	public KitapDTO guncelle(@PathVariable Long id ,@Valid@RequestBody KitapDTO kitapDto) {
		return kitapService.kitapGuncelle(id, kitapDto);
		
	}
	
	@DeleteMapping("/{id}")
	public String sil(@PathVariable Long id) {
		kitapService.kitapSil(id);
		return id + "Numaralı kitap başarıyla silindi";
		
	}
	
}
