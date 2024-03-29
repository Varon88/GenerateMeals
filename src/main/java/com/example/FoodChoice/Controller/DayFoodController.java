package com.example.FoodChoice.Controller;

import com.example.FoodChoice.Service.impl.FoodService;
import com.example.FoodChoice.dto.DayFood;
import com.example.FoodChoice.dto.DayFoodContainer;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("food")
public class DayFoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("day")
    @Operation(tags = "Recommendation",
               summary = "gets all meal recommendations",
               description = "gets you a recommendation of food for breakfast, lunch and dinner")
    public ResponseEntity<DayFoodContainer> foodSuggestions(){
        return foodService.foodSuggestions();
    }

    @GetMapping("GetAll")
    @Operation(tags = "Get all food",
               summary = "get all types of food",
               description = "reterives all information on all food")
    public ResponseEntity<DayFood> getAllFood(){
        return foodService.getALlFood();
    }

}
