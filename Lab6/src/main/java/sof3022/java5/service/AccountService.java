package sof3022.java5.service;

import sof3022.java5.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> getAllAccounts();

    Account createNewAccount(Account account);

    Account updateAccountByUsername(String username, Account account);

    void deleteAccountById(String username);

    Optional<Account> getAccountByUsername(String username);

}
