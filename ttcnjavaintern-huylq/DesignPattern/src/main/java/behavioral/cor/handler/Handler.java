package behavioral.cor.handler;

import behavioral.cor.Account;

public interface Handler {
    Handler nextHandler(Handler nextHandler);
    void process(Account account);
}
