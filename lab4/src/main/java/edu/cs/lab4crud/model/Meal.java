package edu.cs.lab4crud.model;

/*
  @author   DovhalKyrylo
  @project   lab4
  @class  Meal
  @version  1.0.0
  @since 1.10.2024 - 7.20
*/

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document
public class Meal {
    private String id;
    private String name;
    private String code;
    private String description;

    private int calories;
    private double price;

    public Meal(String name, String code, String description, int calories, double price) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.calories = calories;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(id, meal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
