package com.example.FoodChoice.dao;

import com.example.FoodChoice.Model.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Lunchdao extends JpaRepository<Lunch,Integer> {
}
