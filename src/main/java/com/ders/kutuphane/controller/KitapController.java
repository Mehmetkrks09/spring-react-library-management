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

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/kitaplar")
public class KitapController {

	@Autowired
	private KitapService kitapService;

	// ----------------------------------------------------------------------------------
	@PostMapping("/addBook")
	public ResponseEntity<KitapDTO> addBook(@Valid @RequestBody KitapDTO kitapDto) {
		return ResponseEntity.ok(kitapService.saveBook(kitapDto));

	}
	// ----------------------------------------------------------------------------------

	@PutMapping("/update/{id}")
	public ResponseEntity<KitapDTO> update(@PathVariable Long id, @Valid @RequestBody KitapDTO kitapDto) {
		return ResponseEntity.ok(kitapService.updateBook(id, kitapDto));

	}
	// ----------------------------------------------------------------------------------

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		kitapService.deleteBookById(id);
		return ResponseEntity.ok(id + " numaralı kitap başarıyla silindi.");

	}

	// ------------------------------------------------------------------------------------------
	@GetMapping
	public ResponseEntity<List<KitapDTO>> getAll() {
		return ResponseEntity.ok(kitapService.getAllBooks());
	}

	// --------------------------------------------------------------------
	@GetMapping("/kategori/{categoryId}")
	public ResponseEntity<List<KitapDTO>> getByCategoryId(@PathVariable Long categoryId) {

		List<KitapDTO> kitaplar = kitapService.getByCategoryId(categoryId);
		return ResponseEntity.ok(kitaplar);
	}
	// -----------------------------------------------------------------------

	@GetMapping("/getbook/{id}")
	public ResponseEntity<KitapDTO> getbook(@PathVariable Long id) {
		return ResponseEntity.ok(kitapService.getBook(id));
	}

}
