package com.example.subscribers.services;

import com.example.subscribers.models.Bank;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IBankService {
    List<Bank> getAllBanks();
    Bank getBankByID(int bankID);
    Bank createBank(Bank newBank);
    Bank updateBank(int id, Bank updatedBank);

    ResponseEntity<?> deleteBank(int id);
}
