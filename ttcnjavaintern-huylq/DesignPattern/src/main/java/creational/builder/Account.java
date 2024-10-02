package creational.builder;

public class Account {
    private String email;
    private String password;
    private AccountType accountType;
    private double balance;
    private BankRoll bankRoll;
    private boolean cashCard;
    private boolean smsNotification;
    private boolean balanceChangeNotification;

    public Account(){
    }

    public Account(String email, String password, AccountType accountType, double balance, BankRoll bankRoll, boolean cashCard, boolean smsNotification, boolean balanceChangeNotification) {
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.balance = balance;
        this.bankRoll = bankRoll;
        this.cashCard = cashCard;
        this.smsNotification = smsNotification;
        this.balanceChangeNotification = balanceChangeNotification;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBankRoll(BankRoll bankRoll) {
        this.bankRoll = bankRoll;
    }

    public void setCashCard(boolean cashCard) {
        this.cashCard = cashCard;
    }

    public void setSmsNotification(boolean smsNotification) {
        this.smsNotification = smsNotification;
    }

    public void setBalanceChangeNotification(boolean balanceChangeNotification) {
        this.balanceChangeNotification = balanceChangeNotification;
    }

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accountType=" + accountType +
                ", balance=" + balance +
                ", bankRoll=" + bankRoll +
                ", cashCard=" + cashCard +
                ", smsNotification=" + smsNotification +
                ", balanceChangeNotification=" + balanceChangeNotification +
                '}';
    }

    public enum AccountType {
        TYPE_2, TYPE_3
    }

    public enum BankRoll {
        CREDIT_CARD, BANK_ACCOUNT
    }
}
