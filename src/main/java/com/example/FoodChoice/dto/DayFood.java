package com.example.FoodChoice.dto;

import com.example.FoodChoice.Model.BreakFast;
import com.example.FoodChoice.Model.Dinner;
import com.example.FoodChoice.Model.Lunch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class DayFood {

    List<BreakFast> breakFastList;
    List<Lunch> lunchList;
    List<Dinner> dinnerList;
}
