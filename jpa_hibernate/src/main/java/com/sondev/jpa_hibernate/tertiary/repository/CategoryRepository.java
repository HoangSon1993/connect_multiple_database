package com.sondev.jpa_hibernate.tertiary.repository;

import com.sondev.jpa_hibernate.tertiary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
