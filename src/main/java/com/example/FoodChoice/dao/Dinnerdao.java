package com.example.FoodChoice.dao;

import com.example.FoodChoice.Model.Dinner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dinnerdao extends JpaRepository<Dinner, Integer> {
    List<Dinner> findByType(String type);
}
