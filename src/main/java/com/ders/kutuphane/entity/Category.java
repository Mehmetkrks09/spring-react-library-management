package com.ders.kutuphane.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "kategoriler")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public List<Kitap> getKitaplar() {
		return kitaplar;
	}

	public void setKitaplar(List<Kitap> kitaplar) {
		this.kitaplar = kitaplar;
	}

	@Column(nullable = false, unique = true)
	private String isim;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Kitap> kitaplar;

}
