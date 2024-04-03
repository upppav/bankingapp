package com.javasb.bankingapp.mapper;

import com.javasb.bankingapp.Dto.AccountDto;
import com.javasb.bankingapp.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto)
    {
        Account account=new Account(
        accountDto.getId(),
        accountDto.getAccountHolderName(),

        accountDto.getBalence());
        return account;
    }
    public static AccountDto mapToAccountDto(Account account)
    {
        AccountDto accountDto=new AccountDto(account.getId(),account.getAccountHolderName(),account.getBalence());
        return  accountDto;
    }

}
