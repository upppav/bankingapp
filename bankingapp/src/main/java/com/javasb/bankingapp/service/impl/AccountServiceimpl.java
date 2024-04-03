package com.javasb.bankingapp.service.impl;

import com.javasb.bankingapp.Dto.AccountDto;
import com.javasb.bankingapp.entity.Account;
import com.javasb.bankingapp.mapper.AccountMapper;
import com.javasb.bankingapp.repository.AccountRepository;
import com.javasb.bankingapp.service.AcoountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceimpl implements AcoountService {

    private AccountRepository accountRepository;
    public AccountServiceimpl(AccountRepository accountRepository)
    {
        this.accountRepository=accountRepository;
    }
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto getAccoutBtId(Long id) {
        Account account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account id is not present"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto amountDeposit(Long id, double amount) {
        Account account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account id is not present"));
        double total=account.getBalence()+amount;
        account.setBalence(total);
        Account savedAccount=accountRepository.save(account);

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account id is not present"));
        if(account.getBalence()<amount)
        {
            throw new RuntimeException("insufficient balance.");
        }
        double total=account.getBalence()-amount;
        account.setBalence(total);
        Account savedAccount=accountRepository.save(account);

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
    return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

    }

    @Override
    public void DeleteAccount(Long id) {
        Account account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account id is not present"));
        accountRepository.deleteById(id);
    }
}
