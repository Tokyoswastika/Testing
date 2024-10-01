package edu.cs.lab4crud.controller;

/*
  @author   DovhalKyrylo
  @project   lab4
  @class  MealRestController
  @version  1.0.0
  @since 1.10.2024 - 20.50
*/

import edu.cs.lab4crud.model.Meal;
import edu.cs.lab4crud.repository.MealRepository;
import edu.cs.lab4crud.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/meals/")
@RequiredArgsConstructor
public class MealRestController {
    private final MealService mealService;

    @GetMapping
    public List<Meal> getAll() {
        return mealService.getAll();
    }

    // read one
    @GetMapping("{id}")
    public Meal showOneById(@PathVariable String id) {
        return mealService.getById(id);
    }

    @PostMapping
    public Meal insert(@RequestBody Meal Meal) {
        return mealService.create(Meal);
    }

    @PutMapping
    public Meal edit(@RequestBody Meal Meal) {
        return mealService.update(Meal);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        mealService.delById(id);
    }

}
