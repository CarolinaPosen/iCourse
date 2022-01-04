package by.itacademy.mikhalevich.icourse.impl;

import by.itacademy.mikhalevich.icourse.AccountService;
import by.itacademy.mikhalevich.icourse.model.Account;
import by.itacademy.mikhalevich.icourse.model.CurrentAccount;
import by.itacademy.mikhalevich.icourse.repository.LoginPasswordSource;

import java.util.*;

class AccountServiceImpl implements AccountService {

    private final LoginPasswordSource loginPasswordSource;

    public AccountServiceImpl(LoginPasswordSource loginPasswordSource) {
        super();
        this.loginPasswordSource = loginPasswordSource;
    }

    @Override
    public CurrentAccount authentificate(String login, String password) {
        return (equalsPassword(password, getAccountByLogin(login)));
    }

    private CurrentAccount equalsPassword(String password, Account account) {
        if(account!=null && password.equals(account.getPassword())){
            return account;
        }
        return null;
    }

    private Account getAccountByLogin(String login){
        for (Map.Entry<Long, Account> entry : loginPasswordSource.getLoginMap().entrySet()) {
            if (Objects.equals(login, entry.getValue().getEmail())) {
                return loginPasswordSource.getAccountById(entry.getKey());
            }
        }
        return null;
    }
}
