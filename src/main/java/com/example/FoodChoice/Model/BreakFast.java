package com.example.FoodChoice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@ToString
public class BreakFast {

    @Id
    private Integer id;
    private String name;
    private String type;
}
