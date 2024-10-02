package behavioral.cor.handler;

import behavioral.cor.Account;

public class RequestHandler extends BaseHandler {
    private AuthorizationHandler authorizationHandler;
    private DataValidationHandler dataValidationHandler;

    public RequestHandler(AuthorizationHandler authorizationHandler, DataValidationHandler dataValidationHandler) {
        this.authorizationHandler = authorizationHandler;
        this.dataValidationHandler = dataValidationHandler;
    }

    @Override
    public void process(Account account) {
        if(nextHandler != null) {
            nextHandler.process(account);
        }
    }
}
