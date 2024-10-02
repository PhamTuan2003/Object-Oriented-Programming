package vn.com.vds.service;

import org.springframework.stereotype.Component;
import vn.com.vds.model.Account;

@Component
public class AuthenticationService {

    public AuthenticationService() {
    }

    public boolean validateAccount(Account account) {
        return account != null;
    }
}
