package com.example.subscribers.controllers;

import com.example.subscribers.exceptions.ResourceNotFoundException;
import com.example.subscribers.models.Bank;
import com.example.subscribers.services.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BankController {

    IBankService bankService;
    @Autowired
    public BankController(IBankService bankService){
        this.bankService = bankService;
    }
    //Get all banks
    @GetMapping("/banks")
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }

    //Get banks by ID
    @GetMapping("/banks/{id}")
    public Bank getBankById(@PathVariable(value = "id") int bankID){
        return this.bankService.getBankByID(bankID);
    }
    //Create new bank
    @PostMapping("/banks")
    public Bank createBank(@Valid @RequestBody Bank bank){
        return this.bankService.createBank(bank);
    }
    //Update bank by id
    @PutMapping("/banks/{id}")
    public Bank updateBankById(@PathVariable(value = "id") int bankID, @Valid @RequestBody Bank bankDetails){
        return this.bankService.updateBank(bankID,bankDetails);
    }

    // Delete a Bank
    @DeleteMapping("/banks/{id}")
    public ResponseEntity<?> deleteBank(@PathVariable(value = "id") int id) {

        return this.bankService.deleteBank(id);

    }

}
