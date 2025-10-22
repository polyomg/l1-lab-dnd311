package sof3022.java5.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sof3022.java5.entity.Account;
import sof3022.java5.repository.AccountRepository;
import sof3022.java5.service.AccountService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public Account createNewAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public Account updateAccountByUsername(String username, Account account) {

        Account existingAccount = this.getAccountByUsername(username).orElseThrow( () -> new RuntimeException("Account not found!!!") );

        existingAccount.builder()
                .password(account.getPassword())
                .email(account.getEmail())
                .photo(account.getPhoto())
                .activated(account.getActivated())
                .admin(account.getAdmin())
                .build();

        return existingAccount;
    }

    @Override
    @Transactional
    public void deleteAccountById(String username) {
        accountRepository.deleteById(username);
    }

    @Override
    public Optional<Account> getAccountByUsername(String username) {
        return accountRepository.findById(username);
    }
}
