package com.ders.kutuphane.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class KitapDTO {

	@NotBlank(message = "Kitap ismi boş olamaz!")
	@Size(min = 2, max = 50, message = "Kitap ismi 2 ile 50 karakter arasında olmalıdır.")
	private String isim;

	@NotBlank(message = "Yazar ismi boş olamaz!")
	private String yazar;

	private int sayfaSayisi;
	
	private CategoryDTO category;
	
	private Long categoryId;
	
	
	
	// -------------------------------------------------------------
	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}


	public int getSayfaSayisi() {
		return sayfaSayisi;
	}

	public void setSayfaSayisi(int sayfaSayisi) {
		this.sayfaSayisi = sayfaSayisi;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getYazar() {
		return yazar;
	}

	public void setYazar(String yazar) {
		this.yazar = yazar;
	}

}
