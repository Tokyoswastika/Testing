package edu.cs.lab4crud.controller;

/*
  @author   DovhalKyrylo
  @project   lab4
  @class  PhoneRestController
  @version  1.0.0
  @since 6.10.2024 - 22.50
*/

import edu.cs.lab4crud.model.Phone;
import edu.cs.lab4crud.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/phones/")
@RequiredArgsConstructor
public class PhoneRestController {
    private final PhoneService phoneService;

    @GetMapping
    public List<Phone> getAll() {
        return phoneService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Phone> showOneById(@PathVariable String id) {
        Phone phone = phoneService.getById(id);
        return phone != null ? ResponseEntity.ok(phone) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Phone> insert(@RequestBody  Phone phone) {
        Phone createdPhone = phoneService.create(phone);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPhone);
    }

    @PutMapping("{id}")
    public ResponseEntity<Phone> edit(@PathVariable String id, @RequestBody  Phone phone) {
        Phone updatedPhone = phoneService.update(phone);
        return ResponseEntity.ok(updatedPhone);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        phoneService.delById(id);
        return ResponseEntity.noContent().build();
    }
}
