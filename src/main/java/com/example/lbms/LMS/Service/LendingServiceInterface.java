package com.example.lbms.LMS.Service;

import com.example.lbms.LMS.Models.Lending;

import java.util.List;

public interface LendingServiceInterface {
    Lending addLending(Lending lending);
    Lending deleteLending(long id);

    Lending updateLending(Long id,Lending lending);
    Lending findLendingById(Long id);
    List<Lending> getAllActiveLendings();
}
