package com.example.lbms.LMS.Exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LendingNotFoundException extends RuntimeException {
    private long id;
    public LendingNotFoundException(Long id,String message) {
        super(message);
        this.id = id;
    }
}
