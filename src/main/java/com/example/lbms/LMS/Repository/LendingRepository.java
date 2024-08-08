package com.example.lbms.LMS.Repository;

import com.example.lbms.LMS.Models.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LendingRepository extends JpaRepository<Lending, Long> {
    Optional<Lending> findById(Long id);

    List<Lending> findAll();

    Lending save(Lending lending);

    void deleteById(Long id);


}
