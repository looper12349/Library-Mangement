package com.example.lbms.LMS.Controllers;

import com.example.lbms.LMS.Models.Lending;
import com.example.lbms.LMS.Service.LendingService;
import com.example.lbms.LMS.Service.LendingServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lendings")
public class LendingController {
    private Logger logger = LoggerFactory.getLogger(LendingController.class);
    private LendingService lendingService;

    LendingController(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    @GetMapping("/{id}")
    public Lending findById(@PathVariable long id) {
        logger.info("Searched Lending by Id: ", id);
        return this.lendingService.findLendingById(id);
    }

    @GetMapping("/")
    public List<Lending> getAllActiveLendings(){
        logger.info("Fetched All Active Lendings");
        return this.lendingService.getAllActiveLendings();
    }

    @PostMapping("/")
    public Lending addLending(@RequestBody Lending lending) {
        logger.info("Added Lending with Id: ", lending.getId());
        return this.lendingService.addLending(lending);
    }

    @PatchMapping("/{id}")
    public Lending updateLending(@PathVariable long id, @RequestBody Lending lending) {
        logger.info("Updated Lending with Id: ", lending.getId());
        return this.lendingService.updateLending(id, lending);
    }

    @DeleteMapping("/{id}")
    public Lending deleteLending(@PathVariable long id) {
        logger.info("Deleted Lending with Id: ", id);
        return this.lendingService.deleteLending(id);
    }
}
