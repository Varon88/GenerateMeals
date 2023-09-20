package com.example.FoodChoice.dto;

import com.example.FoodChoice.Model.BreakFast;
import com.example.FoodChoice.Model.Dinner;
import com.example.FoodChoice.Model.Lunch;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class DayFood {

    private List<BreakFast> breakFastList;
    private List<Lunch> lunchList;
    private List<Dinner> dinnerList;
    
}
