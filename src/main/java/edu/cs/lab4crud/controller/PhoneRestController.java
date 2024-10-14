package edu.cs.lab4crud.controller;

import edu.cs.lab4crud.model.Phone;
import edu.cs.lab4crud.service.PhoneService;
import lombok.RequiredArgsConstructor;
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
    public Phone showOneById(@PathVariable String id) {
        return phoneService.getById(id);
    }

    @PostMapping
    public Phone insert(@RequestBody Phone phone) {
        return phoneService.create(phone);
    }

    @PutMapping("{id}")
    public Phone edit(@PathVariable String id, @RequestBody Phone phone) {
        phone.setId(id); // Ensure the ID in the path matches the Phone object
        return phoneService.update(phone);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        phoneService.delById(id);
    }
}