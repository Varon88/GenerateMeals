package com.example.FoodChoice.Service;

import com.example.FoodChoice.Model.BreakFast;
import com.example.FoodChoice.Model.Dinner;
import com.example.FoodChoice.Model.Lunch;
import com.example.FoodChoice.dto.DayFood;
import com.example.FoodChoice.dto.DayFoodContainer;
import org.springframework.http.ResponseEntity;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

public interface FoodServiceImplementation {

    ResponseEntity<DayFoodContainer> foodSuggestions();
    int getBreakFastcount(List<BreakFast> breakFastList);
    int getLunchcount(List<Lunch> lunchList);
    int getDinnercount(List<Dinner> dinnerList);
    DayOfWeek getDay();
    void saveUsedFood(DayFoodContainer dayFoodContainer);


}
