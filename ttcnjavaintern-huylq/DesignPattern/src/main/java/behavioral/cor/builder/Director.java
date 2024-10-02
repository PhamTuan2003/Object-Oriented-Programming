package behavioral.cor.builder;

import behavioral.cor.handler.*;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public LoginHandler buildLoginHandler() {
        LoginHandlerBuilder loginHandlerBuilder = null;
        if (builder instanceof LoginHandlerBuilder) {
            loginHandlerBuilder = (LoginHandlerBuilder) builder;
        }
        return loginHandlerBuilder.buildLoginAttemptHandler(new LoginAttemptHandler())
                .buildAuthenticationHandler(new AuthenticationHandler())
                .buildAuthorizationHandler(new AuthorizationHandler())
                .build();
    }

    public RequestHandler buildRequestHandler() {
        RequestHandlerBuilder requestHandlerBuilder = null;
        if (builder instanceof RequestHandlerBuilder) {
            requestHandlerBuilder = (RequestHandlerBuilder) builder;
        }
        return requestHandlerBuilder.buildAuthorizationHandler(new AuthorizationHandler())
                .buildDataValidationHandler(new DataValidationHandler("Data"))
                .build();
    }
}
