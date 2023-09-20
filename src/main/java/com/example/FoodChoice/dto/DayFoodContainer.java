package com.example.FoodChoice.dto;

import com.example.FoodChoice.Model.BreakFast;
import com.example.FoodChoice.Model.Dinner;
import com.example.FoodChoice.Model.Lunch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Optional;

@Data
@AllArgsConstructor
@ToString
public class DayFoodContainer {

    private Optional<BreakFast> breakFast;
    private Optional<Lunch> lunch;
    private Optional<Dinner> dinner;
}
