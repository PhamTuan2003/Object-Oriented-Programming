package behavioral.cor.builder;

import behavioral.cor.handler.AuthorizationHandler;
import behavioral.cor.handler.DataValidationHandler;
import behavioral.cor.handler.RequestHandler;

public class RequestHandlerBuilder implements Builder {
    private AuthorizationHandler authorizationHandler;
    private DataValidationHandler dataValidationHandler;

    public RequestHandlerBuilder buildAuthorizationHandler (AuthorizationHandler authorizationHandler){
        this.authorizationHandler = authorizationHandler;
        return this;
    }

    public RequestHandlerBuilder buildDataValidationHandler(DataValidationHandler dataValidationHandler){
        this.dataValidationHandler = dataValidationHandler;
        return this;
    }

    public RequestHandler build(){
        RequestHandler requestHandler = new RequestHandler(authorizationHandler, dataValidationHandler);
        requestHandler.nextHandler(authorizationHandler)
                .nextHandler(dataValidationHandler);
        return requestHandler;
    }
}
