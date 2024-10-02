package behavioral.cor.handler;

import behavioral.cor.Account;

public class AuthenticationHandler extends BaseHandler {

    @Override
    public void process(Account account) {
        if (isValidAccount(account)) {
            System.out.println("Account is valid.");
            if (nextHandler != null) {
                nextHandler.process(account);
            }
        } else {
            System.out.println("Account is not valid.");
        }
    }

    private boolean isValidAccount(Account account) {
        return isValid(account.getUsername()) && isValid(account.getPassword());
    }

    private boolean isValid(String str) {
        return str != null && !str.isEmpty();
    }
}
