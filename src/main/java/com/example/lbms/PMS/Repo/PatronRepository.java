package com.example.lbms.PMS.Repo;


import com.example.lbms.BMS.Model.Book;
import com.example.lbms.PMS.Model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {
    Optional<Patron> findPatronById(Long id);

    Optional<Patron> findPatronByEmail(String email);

    @Override
    void delete(Patron patron);

}