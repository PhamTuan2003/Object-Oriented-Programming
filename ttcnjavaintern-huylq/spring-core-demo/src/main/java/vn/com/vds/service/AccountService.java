package vn.com.vds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.com.vds.model.Account;

public class AccountService {


    private AuthenticationService authenticationService;

    public AccountService() {
    }

    public AccountService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public Account findAccountById(Long id) {
        Account account = new Account();
        if (authenticationService.validateAccount(account) && id != 0) {
            return account;
        } else {
            throw new IllegalStateException("Account not found");
        }
    }
}
