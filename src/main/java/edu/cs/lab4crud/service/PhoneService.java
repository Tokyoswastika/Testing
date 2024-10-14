package edu.cs.lab4crud.service;

/*
  @author   DovhalKyrylo
  @project   lab4-crud
  @class  PhoneService
  @version  1.0.0
  @since 30.09.2024 - 23.59
*/

import edu.cs.lab4crud.model.Phone;
import edu.cs.lab4crud.repository.PhoneRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;
    private List<Phone> phones = new ArrayList<>();

    @PostConstruct
    void init() {
        this.phoneRepository.deleteAll();
        this.phoneRepository.saveAll(this.phones);
    }

    public List<Phone> getAll() {
        return this.phoneRepository.findAll();
    }

    public Phone getById(String id) {
        return this.phoneRepository.findById(id).orElse(null);
    }

    public Phone create(Phone phone) {
        return this.phoneRepository.save(phone);
    }

    public Phone update(Phone phone) {
        return this.phoneRepository.save(phone);
    }

    public void delById(String id) {
        this.phoneRepository.deleteById(id);
    }

    public PhoneService(final PhoneRepository phoneRepository) {
        this.phones.add(new Phone("iPhone 13", "Apple", "Latest model with A15 chip", 128, 799.99));
        this.phones.add(new Phone("Galaxy S21", "Samsung", "Flagship phone with amazing camera", 256, 999.99));
        this.phones.add(new Phone("Pixel 6", "Google", "Best for Android experience", 128, 599.99));
        this.phoneRepository = phoneRepository;
    }
}

