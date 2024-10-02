package behavioral.cor.handler;

import behavioral.cor.Account;

public class BaseHandler implements Handler {
    protected Handler nextHandler;

    @Override
    public Handler nextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    @Override
    public void process(Account account) {

    }
}
