package sof3022.java5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sof3022.java5.entity.Account;
import sof3022.java5.service.AccountService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @RequestMapping("/account/form")
    public String form(Model model)
    {
        model.addAttribute("account", new Account());
        model.addAttribute("accountList", accountService.getAllAccounts());
        return "account-form";
    }

    @PostMapping("/account/create")
    public String create(@ModelAttribute("account") Account account)
    {
        accountService.createNewAccount(account);
        return "redirect:/account/form";
    }

    @PostMapping("/account/update/{username}")
    public String update(
            @PathVariable("username") String username,
            @ModelAttribute("account") Account account)
    {
        accountService.updateAccountByUsername(username, account);
        return "redirect:/account/edit/" + username;
    }

    @GetMapping("/account/delete/{username}")
    public String delete(@PathVariable("username") String username){
        accountService.deleteAccountById(username);
        return  "redirect:/account/form";
    }

    @GetMapping("/account/edit/{username}")
    public String edit(
            Model model,
            @PathVariable("username") String username)
    {
        Optional<Account> optionalAccount = accountService.getAccountByUsername(username);
        if(optionalAccount.isPresent()){
            model.addAttribute("account", optionalAccount.get());
            model.addAttribute("accountList", accountService.getAllAccounts());
            return "account-form";
        }else{
            return "redirect:/account/form";
        }


    }



}
