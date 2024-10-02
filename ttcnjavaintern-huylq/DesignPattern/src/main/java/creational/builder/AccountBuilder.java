package creational.builder;

public class AccountBuilder {
    private String email;
    private String password;
    private Account.AccountType accountType;
    private double balance;
    private Account.BankRoll bankRoll;
    private boolean cashCard;
    private boolean smsNotification;
    private boolean balanceChangeNotification;

    public AccountBuilder email(String email) {
        this.email = email;
        return this;
    }

    public AccountBuilder password(String password) {
        this.password = password;
        return this;
    }

    public AccountBuilder accountType(Account.AccountType accountType) {
        this.accountType = accountType;
        return this;
    }

    public AccountBuilder balance(double balance) {
        this.balance = balance;
        return this;
    }

    public AccountBuilder bankRoll(Account.BankRoll bankRoll) {
        this.bankRoll = bankRoll;
        return this;
    }

    public AccountBuilder cashCard(boolean cashCard) {
        this.cashCard = cashCard;
        return this;
    }

    public AccountBuilder smsNotification(boolean smsNotification) {
        this.smsNotification = smsNotification;
        return this;
    }

    public AccountBuilder balanceChangeNotification(boolean balanceChangeNotification) {
        this.balanceChangeNotification = balanceChangeNotification;
        return this;
    }

    public Account build() {
        return new Account(this.email, this.password, this.accountType, this.balance, this.bankRoll, this.cashCard, this.smsNotification, this.balanceChangeNotification);
    }
}
