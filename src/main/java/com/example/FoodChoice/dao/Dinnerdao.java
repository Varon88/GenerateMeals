package com.example.FoodChoice.dao;

import com.example.FoodChoice.Model.Dinner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dinnerdao extends JpaRepository<Dinner, Integer> {
}
