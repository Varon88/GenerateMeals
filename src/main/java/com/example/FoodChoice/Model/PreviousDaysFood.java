package com.example.FoodChoice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.DayOfWeek;

@Entity
@Data
public class PreviousDaysFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private DayOfWeek day;
    private String name;
    private String type;

    public PreviousDaysFood() {
    }

    public PreviousDaysFood(DayOfWeek day, String name, String type) {
        this.day = day;
        this.name = name;
        this.type = type;
    }
}
