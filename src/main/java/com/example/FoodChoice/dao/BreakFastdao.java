package com.example.FoodChoice.dao;

import com.example.FoodChoice.Model.BreakFast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreakFastdao extends JpaRepository<BreakFast, Integer> {
}
