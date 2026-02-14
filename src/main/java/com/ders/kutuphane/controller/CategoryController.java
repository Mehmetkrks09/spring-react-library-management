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


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/kategoriler")
public class CategoryController {


	
	@Autowired
	private CategoryService categoryService;

 
	
	//------------------------------------------------------------------------------
	@PostMapping("/addCategory")
    public ResponseEntity<CategoryDTO> saveCategory(@RequestBody CategoryDTO dto) {
		
        return new ResponseEntity<>(categoryService.save(dto), HttpStatus.CREATED);
    }
	
	//---------------------------------------------------------------------------

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
    	
        return ResponseEntity.ok(categoryService.getAll());
    }
    
    //---------------------------------------------------------------------------
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
 
    	return ResponseEntity.ok("ID " + id+"Numaralı Kategori silindi");
    }
	
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO dto){
    	
    	return ResponseEntity.ok( categoryService.updateCategory(id, dto));
    }
    
    @GetMapping("/getById/{id}")
    public ResponseEntity<CategoryDTO> getByCategoryId(@PathVariable Long id){
    	
    	return ResponseEntity.ok(categoryService.getByCategoryId(id));
    }
	

}
