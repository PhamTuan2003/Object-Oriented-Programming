package behavioral.cor;

import behavioral.cor.builder.LoginHandlerBuilder;
import behavioral.cor.builder.Director;
import behavioral.cor.builder.RequestHandlerBuilder;
import behavioral.cor.handler.*;

public class CorMain {
    public static final int LOGIN_ATTEMPTS = 4;

    public static void main(String[] args) {
        final Account admin = new Account("10.60.135.37", "p.cds_admin", "Pchuyen$dichso#2028", "admin");

        /* Build login handler manually
        Handler authenticationHandler = new AuthenticationHandler();
        Handler authorizationHandler = new AuthorizationHandler();
        Handler loginAttemptHandler = new LoginAttemptHandler();

        loginAttemptHandler.nextHandler(authenticationHandler);
        authenticationHandler.nextHandler(authorizationHandler);
        loginAttemptHandler.process(admin);
        */

        LoginHandlerBuilder loginHandlerBuilder = new LoginHandlerBuilder();
        Director director = new Director(loginHandlerBuilder);
        Handler loginHandler = director.buildLoginHandler();
        loginHandler.process(admin);

        System.out.println("===== Request Handler =====");
        RequestHandlerBuilder requestHandlerBuilder = new RequestHandlerBuilder();
        director = new Director(requestHandlerBuilder);
        Handler requestHandler = director.buildRequestHandler();
        requestHandler.process(admin);
    }
}
