package com.example.lbms.PMS.Service;

import com.example.lbms.PMS.Model.Patron;

import java.util.List;

public interface PatronServiceInterface {
    Patron addPatron(Patron patron);
    Patron updatePatron(long id, Patron patron);
    Patron deletePatron(long id);

    Patron getSinglePatron(long id);
    List<Patron> getAllPatrons();

}