package com.ders.kutuphane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ders.kutuphane.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
