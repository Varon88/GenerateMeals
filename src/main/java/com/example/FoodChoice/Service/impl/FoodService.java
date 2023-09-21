package com.example.FoodChoice.Service.impl;

import com.example.FoodChoice.Model.BreakFast;
import com.example.FoodChoice.Model.Dinner;
import com.example.FoodChoice.Model.Lunch;
import com.example.FoodChoice.Model.PreviousDaysFood;
import com.example.FoodChoice.Service.FoodServiceImplementation;
import com.example.FoodChoice.dao.BreakFastdao;
import com.example.FoodChoice.dao.Dinnerdao;
import com.example.FoodChoice.dao.LastDaysFooddao;
import com.example.FoodChoice.dao.Lunchdao;
import com.example.FoodChoice.dto.DayFood;
import com.example.FoodChoice.dto.DayFoodContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<DayFoodContainer> foodSuggestions() {
        int bCount = getBreakFastcount(breakFastdao.findAll());
        int lCount = getLunchcount(lunchdao.findAll());
        int dCount = getDinnercount(dinnerdao.findAll());

        Boolean condition = true;
        Random rnd = new Random();


        while(condition == true) {
            int breakFastid = rnd.nextInt(1,bCount);
            int lunchId = rnd.nextInt(1,lCount);
            int dinnerId = rnd.nextInt(1,dCount);
            DayOfWeek day = getDay();
            day = day.minus(1);

            condition = lastDaysFooddao.existsByNameAndTypeAndDay(breakFastdao.findById(breakFastid).get().getName(),"breakfast",day) && lastDaysFooddao.existsByNameAndTypeAndDay(lunchdao.findById(lunchId).get().getName(), "lunch",day) && lastDaysFooddao.existsByNameAndTypeAndDay(dinnerdao.findById(dinnerId).get().getName(),"dinner",day);
            if(condition == false && !day.equals(DayOfWeek.FRIDAY)){
                DayFoodContainer dayFoodContainer = new DayFoodContainer(breakFastdao.findById(breakFastid),lunchdao.findById(lunchId),dinnerdao.findById(dinnerId));
                if(lastDaysFooddao.findAll().size() >= 6){
                    lastDaysFooddao.deleteAll();
                }
                saveUsedFood(dayFoodContainer);
                return new ResponseEntity<>(dayFoodContainer, HttpStatus.OK);
            } else if (!condition && !day.equals(DayOfWeek.FRIDAY)){
                List<BreakFast> vegBreakFast = breakFastdao.findByType("Veg");
                List<Lunch> vegLunch = lunchdao.findByType("Veg");
                List<Dinner> vegDinner = dinnerdao.findByType("Veg");

                int vegBreakCount = rnd.nextInt(1,getBreakFastcount(vegBreakFast));
                int vegLunchCount = rnd.nextInt(1,getLunchcount(vegLunch));
                int vegDinnerCount = rnd.nextInt(1,getDinnercount(vegDinner));
                boolean condition1 = true;

                condition1 = lastDaysFooddao.existsByNameAndTypeAndDay(breakFastdao.findById(vegBreakCount).get().getName(),"breakfast",day) && lastDaysFooddao.existsByNameAndTypeAndDay(lunchdao.findById(vegLunchCount).get().getName(), "lunch",day) && lastDaysFooddao.existsByNameAndTypeAndDay(dinnerdao.findById(vegDinnerCount).get().getName(),"dinner",day);
                if(!condition1 && day.equals(DayOfWeek.FRIDAY)) {
                    DayFoodContainer dayFoodContainer = new DayFoodContainer(breakFastdao.findById(breakFastid), lunchdao.findById(lunchId), dinnerdao.findById(dinnerId));
                    if(lastDaysFooddao.findAll().size() >= 6){
                        lastDaysFooddao.deleteAll();
                    }
                    saveUsedFood(dayFoodContainer);
                    return new ResponseEntity<>(dayFoodContainer, HttpStatus.OK);
                }
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
        BreakFast breakFast = dayFoodContainer.getBreakFast().get();
        Lunch lunch = dayFoodContainer.getLunch().get();
        Dinner dinner = dayFoodContainer.getDinner().get();

        lastDaysFooddao.save(new PreviousDaysFood(day, breakFast.getName(), "breakfast"));
        lastDaysFooddao.save(new PreviousDaysFood(day, lunch.getName(), "lunch"));
        lastDaysFooddao.save(new PreviousDaysFood(day, dinner.getName(), "dinner"));
    }

    @Override
    public ResponseEntity<DayFood> getALlFood() {
        DayFood dayFood = new DayFood();
        dayFood.setBreakFastList(breakFastdao.findAll());
        dayFood.setLunchList(lunchdao.findAll());
        dayFood.setDinnerList(dinnerdao.findAll());
        return new ResponseEntity<>(dayFood, HttpStatus.OK);
    }


}

























