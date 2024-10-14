package edu.cs.lab4crud.controller;

import edu.cs.lab4crud.model.Phone;
import edu.cs.lab4crud.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/phones")
@RequiredArgsConstructor
public class PhoneRestController {

    private final PhoneService phoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> getAllPhones() {
        List<Phone> phones = phoneService.getAll();
        return ResponseEntity.ok(phones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable String id) {
        Phone phone = phoneService.getById(id);
        return phone != null ? ResponseEntity.ok(phone) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) {
        Phone createdPhone = phoneService.create(phone);
        return ResponseEntity.status(201).body(createdPhone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phone> updatePhone(@PathVariable String id, @RequestBody Phone phone) {
        phone.setId(id);
        Phone updatedPhone = phoneService.update(phone);
        return updatedPhone != null ? ResponseEntity.ok(updatedPhone) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable String id) {
        phoneService.delById(id);
        return ResponseEntity.noContent().build();
    }
}
