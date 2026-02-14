package com.ders.kutuphane;

import static org.junit.jupiter.api.Assertions.assertNotNull; // assertNotNull için şart
import org.junit.jupiter.api.Test; // @Test notasyonu için şart
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ders.kutuphane.dto.KitapDTO;
import com.ders.kutuphane.entity.Kitap;
import com.ders.kutuphane.service.KitapService;
@SpringBootTest // Spring bağlamını yükleyerek test eder
public class KitapServiceTest {

	@Autowired
	private KitapService kitapService;

	@Test
	void kitapEklemeTesti() {
	    // Kitap yerine KitapDTO kullanıyoruz
	    KitapDTO dto = new KitapDTO(); 
	    dto.setIsim("Test Kitabı");
	    dto.setYazar("Test Yazarı");
	    dto.setSayfaSayisi(300);
	    dto.setCategoryId(1L); // Mevcut bir kategori ID'si ver
	    
	    // Metot artık beklediği tipi (DTO) alacak
	    KitapDTO sonuc = kitapService.saveBook(dto);
	    
	    // Sonuçta bir ID dönüp dönmediğini kontrol et
	    assertNotNull(sonuc.getId()); 
	}
}