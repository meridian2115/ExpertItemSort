package com.example.demo.repository;

import com.example.demo.models.ExpertItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Fedor Danilov 15.11.2021
 */
@Repository
public interface ExpertItemRepository extends JpaRepository<ExpertItem, Long> {
    public List<ExpertItem> findByCode(String code);
}