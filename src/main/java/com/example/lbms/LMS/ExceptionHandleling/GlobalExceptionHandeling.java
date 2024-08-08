package com.example.lbms.LMS.ExceptionHandleling;

import com.example.lbms.LMS.DTOs.ExceptionDTO;
import com.example.lbms.LMS.Exceptions.LendingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandeling {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> handleArithmeticException(Exception e){
        ExceptionDTO exceptionDTO = new ExceptionDTO();

        exceptionDTO.setMessage("Something went wrong");
        exceptionDTO.setResolution("Arithmetic Exception");
        ResponseEntity<ExceptionDTO> responseEntity = new ResponseEntity<>(exceptionDTO,HttpStatus.BAD_REQUEST);

        return responseEntity;

    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDTO> handleArrayIndexOutOfBoundsException(Exception e){
        ExceptionDTO exceptionDTO = new ExceptionDTO();

        exceptionDTO.setMessage("Something went wrong");
        exceptionDTO.setResolution("ArrayIndexOutOfBounds Exception");
        ResponseEntity<ExceptionDTO> responseEntity = new ResponseEntity<>(exceptionDTO,HttpStatus.BAD_REQUEST);

        return responseEntity;

    }

    @ExceptionHandler(LendingNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(LendingNotFoundException lendingNotFoundException){
        ExceptionDTO exceptionDTO = new ExceptionDTO();

        exceptionDTO.setMessage("Product Id " + lendingNotFoundException.getId() + " not found");
        exceptionDTO.setResolution("Lending Not Found");
        ResponseEntity<ExceptionDTO> responseEntity = new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);

        return responseEntity;
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionDTO> handleAllExceptions(Exception e){
//        ExceptionDTO exceptionDTO = new ExceptionDTO();
//
//        exceptionDTO.setMessage("Something went wrong");
//        exceptionDTO.setResolution("Exception");
//        ResponseEntity<ExceptionDTO> responseEntity = new ResponseEntity<>(exceptionDTO,HttpStatus.BAD_REQUEST);
//
//        return responseEntity;
//    }
}
