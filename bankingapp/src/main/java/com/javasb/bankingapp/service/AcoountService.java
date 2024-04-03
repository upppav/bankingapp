package com.javasb.bankingapp.service;

import com.javasb.bankingapp.Dto.AccountDto;
import lombok.Data;

import java.util.List;


public interface AcoountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccoutBtId(Long id);
    AccountDto amountDeposit(Long id , double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void DeleteAccount(Long id);
}
