package behavioral.cor.handler;

import behavioral.cor.Account;

public class LoginHandler extends BaseHandler {
    private AuthenticationHandler authenticationHandler;
    private AuthorizationHandler authorizationHandler;
    private LoginAttemptHandler loginAttemptHandler;

    public LoginHandler(AuthenticationHandler authenticationHandler, AuthorizationHandler authorizationHandler, LoginAttemptHandler loginAttemptHandler) {
        this.authenticationHandler = authenticationHandler;
        this.authorizationHandler = authorizationHandler;
        this.loginAttemptHandler = loginAttemptHandler;
    }

    @Override
    public void process(Account account) {
        nextHandler.process(account);
    }
}
