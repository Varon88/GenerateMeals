package com.example.FoodChoice.dao;

import com.example.FoodChoice.Model.BreakFast;
import com.example.FoodChoice.Model.PreviousDaysFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LastDaysFooddao extends JpaRepository<PreviousDaysFood, Integer> {


    boolean checkIfUsed(String name, String type);
}
