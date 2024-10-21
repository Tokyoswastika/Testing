package edu.cs.lab4crud;

/*
  @author   DovhalKyrylo
  @project   lab6
  @class  RepositoryTest
  @version  1.0.0
  @since 21.10.24 - 15.48
*/
import edu.cs.lab4crud.model.Phone;
import edu.cs.lab4crud.repository.PhoneRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class RepositoryTests {

    @Autowired
    private PhoneRepository phoneRepository;

    private Phone phone1;
    private Phone phone2;

    @BeforeEach
    void setUp() {
        phone1 = new Phone("1", "iPhone 14", "Apple", "Latest Apple smartphone", 128, 999.99);
        phone2 = new Phone("2", "Samsung Galaxy S21", "Samsung", "Latest Samsung smartphone", 256, 799.99);
        phoneRepository.save(phone1);
        phoneRepository.save(phone2);
    }

    @AfterEach
    void tearDown() {
        phoneRepository.deleteAll();
    }


    @Test
    void shouldCreateNewPhone() {
        Phone phone3 = new Phone("3", "Google Pixel 6", "Google", "Latest Google smartphone", 128, 599.99);
        Phone createdPhone = phoneRepository.save(phone3);

        assertNotNull(createdPhone);
        assertNotNull(createdPhone.getId()); // ID should be generated
        assertEquals(phone3.getModel(), createdPhone.getModel());
    }


    @Test
    void shouldRetrievePhoneById() {
        Optional<Phone> retrievedPhone = phoneRepository.findById(phone1.getId());

        assertTrue(retrievedPhone.isPresent());
        assertEquals(phone1.getModel(), retrievedPhone.get().getModel());
    }

    @Test
    void shouldReturnEmptyOptionalForNonExistentPhone() {
        Optional<Phone> retrievedPhone = phoneRepository.findById("non-existent-id");

        assertFalse(retrievedPhone.isPresent());
    }


    @Test
    void shouldUpdateExistingPhone() {
        phone1.setPrice(949.99);
        Phone updatedPhone = phoneRepository.save(phone1);

        assertNotNull(updatedPhone);
        assertEquals(949.99, updatedPhone.getPrice());
    }


    @Test
    void shouldDeletePhone() {
        phoneRepository.delete(phone1);
        Optional<Phone> deletedPhone = phoneRepository.findById(phone1.getId());

        assertFalse(deletedPhone.isPresent());
    }

    @Test
    void shouldNotThrowErrorWhenDeletingNonExistentPhone() {
        assertDoesNotThrow(() -> phoneRepository.deleteById("non-existent-id"));
    }


    @Test
    void shouldRetrieveAllPhones() {
        List<Phone> allPhones = phoneRepository.findAll();

        assertNotNull(allPhones);
        assertEquals(2, allPhones.size());
    }

    @Test
    void shouldReturnEmptyListWhenNoPhonesExist() {
        phoneRepository.deleteAll();
        List<Phone> allPhones = phoneRepository.findAll();

        assertNotNull(allPhones);
        assertTrue(allPhones.isEmpty());
    }
}
