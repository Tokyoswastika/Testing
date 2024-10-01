package edu.cs.lab4crud.repository;

/*
  @author   DovhalKyrylo
  @project   lab4
  @class  MealRepository
  @version  1.0.0
  @since 1.10.2024 - 8.02
*/

import edu.cs.lab4crud.model.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends MongoRepository<Meal, String> {
}
