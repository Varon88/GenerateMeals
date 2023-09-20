package com.example.FoodChoice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class PreviousDaysFood {

    @Id
    private Integer id;
    private String day;
    private String name;
    private String type;

}
