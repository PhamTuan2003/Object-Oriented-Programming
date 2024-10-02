package behavioral.cor.builder;

import behavioral.cor.handler.*;

public class LoginHandlerBuilder implements Builder {
    private AuthenticationHandler authenticationHandler;
    private AuthorizationHandler authorizationHandler;
    private LoginAttemptHandler loginAttemptHandler;

    public LoginHandlerBuilder buildAuthenticationHandler(AuthenticationHandler authenticationHandler) {
        this.authenticationHandler = authenticationHandler;
        return this;
    }

    public LoginHandlerBuilder buildAuthorizationHandler(AuthorizationHandler authorizationHandler) {
        this.authorizationHandler = authorizationHandler;
        return this;
    }

    public LoginHandlerBuilder buildLoginAttemptHandler(LoginAttemptHandler loginAttemptHandler) {
        this.loginAttemptHandler = loginAttemptHandler;
        return this;
    }

    public LoginHandler build() {
        LoginHandler loginHandler = new LoginHandler(authenticationHandler, authorizationHandler, loginAttemptHandler);
        loginHandler.nextHandler(loginAttemptHandler)
                .nextHandler(authenticationHandler)
                .nextHandler(authorizationHandler);
        return loginHandler;
    }
}
