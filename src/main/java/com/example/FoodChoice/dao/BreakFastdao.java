package com.example.FoodChoice.dao;

import com.example.FoodChoice.Model.BreakFast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreakFastdao extends JpaRepository<BreakFast, Integer> {
    List<BreakFast> findbyType(String veg);
}
