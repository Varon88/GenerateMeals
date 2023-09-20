package com.example.FoodChoice.Service.impl;

import com.example.FoodChoice.Model.BreakFast;
import com.example.FoodChoice.Model.Dinner;
import com.example.FoodChoice.Model.Lunch;
import com.example.FoodChoice.Service.FoodServiceImplementation;
import com.example.FoodChoice.dao.BreakFastdao;
import com.example.FoodChoice.dao.Dinnerdao;
import com.example.FoodChoice.dao.LastDaysFooddao;
import com.example.FoodChoice.dao.Lunchdao;
import com.example.FoodChoice.dto.DayFood;
import com.example.FoodChoice.dto.DayFoodContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class FoodService implements FoodServiceImplementation {

    @Autowired
    BreakFastdao breakFastdao;
    @Autowired
    Lunchdao lunchdao;
    @Autowired
    Dinnerdao dinnerdao;
    @Autowired
    LastDaysFooddao lastDaysFooddao;



    @Override
    public ResponseEntity<List<DayFood>> foodSuggestions() {
        int bCount = getBreakFastcount(breakFastdao.findAll());
        int lCount = getLunchcount(lunchdao.findAll());
        int dCount = getDinnercount(dinnerdao.findAll());

        Boolean condition = false;
        Random rnd = new Random();


        while(condition == false) {
            int breakFastid = rnd.nextInt(bCount);
            int lunchId = rnd.nextInt(lCount);
            int dinnerId = rnd.nextInt(dCount);

            condition = lastDaysFooddao.checkIfUsed(breakFastdao.findById(breakFastid).get().getName(),"breakfast") && lastDaysFooddao.checkIfUsed(lunchdao.findById(lunchId).get().getName(), "lunch") && lastDaysFooddao.checkIfUsed(dinnerdao.findById(dinnerId).get().getName(),"dinner");
            if(condition == true){
                DayFoodContainer dayFoodContainer = new DayFoodContainer(breakFastdao.findById(breakFastid),lunchdao.findById(lunchId),dinnerdao.findById(dinnerId));
                saveUsedFood(dayFoodContainer);
            }
        }


    }

    @Override
    @Cacheable("Bcount")
    public int getBreakFastcount(List<BreakFast> breakFastList) {
        return breakFastList.size();
    }

    @Override
    @Cacheable("Lcount")
    public int getLunchcount(List<Lunch> lunchList) {
        return lunchList.size();
    }

    @Override
    @Cacheable("Dcount")
    public int getDinnercount(List<Dinner> dinnerList) {
        return dinnerList.size();
    }

    @Override
    public DayOfWeek getDay() {
        LocalDate today =  LocalDate.now();
        return today.getDayOfWeek();
    }

    @Override
    public void saveUsedFood(DayFoodContainer dayFoodContainer) {
        DayOfWeek day = getDay();


    }


}

























