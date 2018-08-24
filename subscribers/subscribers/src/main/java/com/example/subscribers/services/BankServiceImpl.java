package com.example.subscribers.services;

import com.example.subscribers.exceptions.ResourceNotFoundException;
import com.example.subscribers.models.Bank;
import com.example.subscribers.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements IBankService {
    BankRepository bankRepository;
    @Autowired
    public BankServiceImpl(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Bank> getAllBanks() {
        return this.bankRepository.findAll();
    }
    @Override
    public Bank getBankByID(int bankID) {
        return this.bankRepository.findById(bankID)
                .orElseThrow(() -> new ResourceNotFoundException("Bank", "id", bankID));
    }

    @Override
    public Bank createBank(Bank newBank) {
        bankRepository.save(newBank);
        return newBank;
    }

    @Override
    public Bank updateBank(int id, Bank bankDetails) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bank", "id", id));
        bank.setDescription(bankDetails.getDescription());
        bank.setEIK(bankDetails.getEIK());
        bank.setPassword(bankDetails.getPassword());
        bank.setUsername(bankDetails.getUsername());

        Bank updatedBank = bankRepository.save(bank);
        return updatedBank;
    }

    @Override
    public ResponseEntity<?> deleteBank(int id) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bank", "id", id));

        bankRepository.delete(bank);

        return ResponseEntity.ok().build();
    }


}
