package com.example.lbms.LMS.Service;

import com.example.lbms.LMS.Exceptions.LendingNotFoundException;
import com.example.lbms.LMS.Models.Lending;
import com.example.lbms.LMS.Repository.LendingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LendingService implements LendingServiceInterface{
    private LendingRepository lendingRepository;

    LendingService(LendingRepository lendingRepository) {
        this.lendingRepository = lendingRepository;
    }

    @Override
    public Lending findLendingById(Long id) {
        Optional<Lending> lending = lendingRepository.findById(id);

        if(lending.isEmpty()){
            throw new LendingNotFoundException(id,"Lending Not Found");
        }
        return lending.get();
    }

    @Override
    public List<Lending> getAllActiveLendings() {
        return lendingRepository.findAll();
    }

    @Override
    public Lending addLending(Lending lending) {
        return lendingRepository.save(lending);
    }

    @Override
    public Lending deleteLending(long id) {
        Optional<Lending> lending = lendingRepository.findById(id);

        if(lending.isEmpty()){
            throw new LendingNotFoundException(id,"Lending Not Found");
        }

        Lending lendingToDelete = lending.get();
        lendingRepository.deleteById(id);

        return lendingToDelete;
    }

    @Override
    public Lending updateLending(Long id, Lending lending) {
        Optional<Lending> optionallending = lendingRepository.findById(id);

        if(optionallending.isEmpty()){
            throw new LendingNotFoundException(id,"Lending Not Found");
        }

        Lending existingLending = optionallending.get();

        if(lending.getBookId()!=0){
            existingLending.setBookId(lending.getBookId());
        }

        if(lending.getPatronId()!=0){
            existingLending.setPatronId(lending.getPatronId());
        }

        if(lending.getBorrowedDate()!=null){
            existingLending.setBorrowedDate(lending.getBorrowedDate());
        }

        if(lending.getDueDate()!=null){
            existingLending.setDueDate(lending.getDueDate());
        }

        return lendingRepository.save(existingLending);
    }

}
