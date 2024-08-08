package com.example.lbms.PMS.Controller;

import com.example.lbms.PMS.Model.Patron;
import com.example.lbms.PMS.Service.PatronService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrons")
public class PMSController {
    private Logger logger = LoggerFactory.getLogger(PMSController.class);
    private final PatronService patronService;

    PMSController(PatronService patronService){
        this.patronService = patronService;
    }

    // Create A Patron
    @PostMapping("/")
    public Patron addPatron(@RequestBody Patron patron){
        logger.info("Created New Patron: ", patron.getName());
        return patronService.addPatron(patron);
    }

    //      Update A patron using patch
    @PatchMapping("/{id}")
    public Patron updatePatron(@PathVariable("id") Long id, @RequestBody Patron patron){
        logger.info("Updated the Patron: ", patron.getName());
        return patronService.updatePatron(id, patron);
    }

    //      Delete a Patron
    @DeleteMapping("/{id}")
    public Patron deletePatron(@PathVariable("id") Long id){
        logger.info("Deleted Patron with Id: ", id);
        return patronService.deletePatron(id);
    }

    //      Get a Patron by Id
    @GetMapping("/{id}")
    public Patron getSinglePatron(@PathVariable("id") Long id) {
        logger.info("Searched A Patron with Id: ", id);
        return patronService.getSinglePatron(id);
    }

    //    Get all Patrons
    @GetMapping("/")
    public List<Patron> getAllPatrons() {
        logger.info("Get All Patrons");
        return patronService.getAllPatrons();
    }

}
