package com.ders.kutuphane.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> validationHatalariniYakala(MethodArgumentNotValidException ex) {

		Map<String, String> hatalar = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(hata -> {
			
			hatalar.put(hata.getField(), hata.getDefaultMessage());
		});
		
		return new ResponseEntity<>(hatalar, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(KitapBulunamadiException.class)
	public ResponseEntity<String> kitapBulunamadiYakalayici(KitapBulunamadiException ex) {
	    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<String> handleCategoryNotFound(CategoryNotFoundException ex) {
	    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}
