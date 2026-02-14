package com.ders.kutuphane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ders.kutuphane.entity.Kitap;

@Repository
public interface KitapRepository extends JpaRepository<Kitap, Long>{
	
	List<Kitap> findByCategoryId(Long categoryId);

}
