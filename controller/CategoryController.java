package com.ders.kutuphane.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ders.kutuphane.dto.CategoryDTO;
import com.ders.kutuphane.service.CategoryService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/kategoriler")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
    public ResponseEntity<CategoryDTO> kategoriEkle(@RequestBody CategoryDTO dto) {
        return new ResponseEntity<>(categoryService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> tumKategoriler() {
        return ResponseEntity.ok(categoryService.getAll());
    }
	
	

}
