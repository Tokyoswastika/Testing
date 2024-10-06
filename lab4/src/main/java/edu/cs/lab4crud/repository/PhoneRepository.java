package edu.cs.lab4crud.repository;

/*
  @author   DovhalKyrylo
  @project   lab4
  @class  MealRepository
  @version  1.0.0
  @since 6.10.2024 - 22.02
*/

import edu.cs.lab4crud.model.Phone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends MongoRepository<Phone, String> {
}
