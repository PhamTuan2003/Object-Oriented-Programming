package behavioral.cor.handler;

import behavioral.cor.Account;
import behavioral.cor.CorMain;

public class LoginAttemptHandler extends BaseHandler {
    @Override
    public void process(Account account) {
        if (!isExceeded(account.getIpAddress())) {
            System.out.println("Login attempt is not exceeded.");
            if (nextHandler != null) {
                nextHandler.process(account);
            }
        } else {
            System.out.println("Several login attempts failed. Please wait for 5 minutes.");
        }
    }

    private boolean isExceeded(String ipAddress) {
        return CorMain.LOGIN_ATTEMPTS >= 5;
    }
}
