package com.example.FoodChoice.dao;

import com.example.FoodChoice.Model.BreakFast;
import com.example.FoodChoice.Model.PreviousDaysFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.Optional;

@Repository
public interface LastDaysFooddao extends JpaRepository<PreviousDaysFood, Integer> {

//    @Query(value = "SELECT COUNT(*) > 0 FROM previous_days_food WHERE name = :name AND type = :type AND day = :day", nativeQuery = true)
//    default Boolean checkIfUsed(String name, String type, DayOfWeek day){
//        if(@Query(value = "SELECT COUNT(*) > 0 FROM previous_days_food WHERE name = :name AND type = :type AND day = :day", nativeQuery = true) == 1){
//            return false
//        }
//    }

    boolean existsByNameAndTypeAndDay(String name, String type, DayOfWeek day);

}
