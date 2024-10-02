package behavioral.cor.handler;

import behavioral.cor.Account;

public class DataValidationHandler extends BaseHandler {
    private String data;

    public DataValidationHandler(String data) {
        this.data = data;
    }

    @Override
    public void process(Account account) {
        if (isValidData()) {
            System.out.println("Data is valid.");
            if (nextHandler != null) {
                nextHandler.process(account);
            }
        } else {
            System.out.println("Data is not valid.");
        }
    }

    private boolean isValidData() {
        return data != null && !data.isEmpty();
    }
}
