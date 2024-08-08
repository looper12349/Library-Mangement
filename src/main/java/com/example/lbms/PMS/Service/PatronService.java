package com.example.lbms.PMS.Service;

import com.example.lbms.PMS.Exceptions.PatronNotFoundException;
import com.example.lbms.PMS.Model.Patron;
import com.example.lbms.PMS.Repo.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatronService implements PatronServiceInterface{

    // create
    // update
    // delete
    // getAll
    // getById
    private final PatronRepository patronRepository;

    PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    @Override
    public Patron addPatron(Patron patron) {
        Optional<Patron> existingPatron = patronRepository.findPatronByEmail(patron.getEmail());
        if(existingPatron.isEmpty()) {
            return patronRepository.save(patron);
        }

        return existingPatron.get();
    }


    @Override
    public Patron updatePatron(long id, Patron patron) {
        Optional<Patron> existingPatronOptional = patronRepository.findById(id);

        if (existingPatronOptional.isPresent()) {
            Patron existingPatron = existingPatronOptional.get();

            // Update the properties of the existing patron with the properties of the provided patron
            if (patron.getName() != null) {
                existingPatron.setName(patron.getName());
            }
            if (patron.getEmail() != null) {
                existingPatron.setEmail(patron.getEmail());
            }


            // Save the updated patron
            return patronRepository.save(existingPatron);
        }

        else {
            // Patron not found, return null or throw an exception
            throw new PatronNotFoundException("Invalid patron entered"); // You can modify this part based on your error handling strategy
        }
    }

    @Override
    public Patron deletePatron(long id) {
        Optional<Patron> existingPatronOptional = patronRepository.findById(id);

        if (existingPatronOptional.isPresent()) {
            // Patron found, delete it from the repository
            patronRepository.delete(existingPatronOptional.get());
            return existingPatronOptional.get();
        } else {
            // Patron not found, return null or throw an exception
            throw new PatronNotFoundException("Patron not found"); // You can modify this part based on your error handling strategy
        }
    }

    @Override
    public Patron getSinglePatron(long id) {
        Optional<Patron> optionalPatron = patronRepository.findById(id);
        if(optionalPatron.isEmpty()) {
            throw new PatronNotFoundException("Patron not Found");
        }
        Patron patron = optionalPatron.get();
        return patron;
    }

    @Override
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

}