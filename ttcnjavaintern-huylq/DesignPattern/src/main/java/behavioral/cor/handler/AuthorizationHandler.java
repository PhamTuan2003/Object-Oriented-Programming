package behavioral.cor.handler;

import behavioral.cor.Account;

public class AuthorizationHandler extends BaseHandler {
    @Override
    public void process(Account account) {
        if (authorize(account.getRole())) {
            System.out.println("Account is authorized.");
            if (nextHandler != null) {
                nextHandler.process(account);
            }
        } else {
            System.out.println("Account does not have permission.");
        }
    }

    private boolean authorize(String role) {
        return role != null && !role.isEmpty();
    }
}
