package com.javasb.bankingapp.controller;

import com.javasb.bankingapp.Dto.AccountDto;
import com.javasb.bankingapp.service.AcoountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AcoountService acoountService;

    public AccountController(AcoountService acoountService) {
        this.acoountService = acoountService;
    }
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(acoountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
    {
        AccountDto accountDto=acoountService.getAccoutBtId(id);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id , @RequestBody  Map<String,Double> request)
    {
        Double amount =request.get("amount");
        AccountDto accountDto=acoountService.amountDeposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawAmount(@PathVariable Long id , @RequestBody Map<String,Double> request)
    {
        Double amount =request.get("amount");
        AccountDto accountDto=acoountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    @GetMapping("/getAccounts")
    public ResponseEntity<List<AccountDto>>  getAllAccounts()
    {
        List<AccountDto> list=acoountService.getAllAccounts();
        return ResponseEntity.ok(list);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id)
    {
        acoountService.DeleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }

}
