package com.example.FoodChoice.Controller;

import com.example.FoodChoice.Service.impl.FoodService;
import com.example.FoodChoice.dto.DayFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("food")
public class DayFoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("day")
    public ResponseEntity<List<DayFood>> foodSuggestions(){
        return foodService.foodSuggestions();
    }

}
