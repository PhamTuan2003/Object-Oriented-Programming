package creational.builder;

public class Client {
    public static void main(String[] args) {
        Account account = createAccountUsingBuilder();

        System.out.println(account);
    }

    private static Account createAccountUsingSetter() {
        Account account = new Account();

        account.setEmail("Account");
        account.setPassword("Password");
        account.setBalance(123D);
        account.setBankRoll(Account.BankRoll.BANK_ACCOUNT);
        account.setAccountType(Account.AccountType.TYPE_2);
        account.setCashCard(true);
        account.setSmsNotification(true);
        account.setBalanceChangeNotification(true);

        return account;
    }

    private static Account createAccountUsingBuilder() {
        AccountBuilder accountBuilder = new AccountBuilder();

        accountBuilder.email("Account")
                .password("Password")
                .balance(123D)
                .bankRoll(Account.BankRoll.BANK_ACCOUNT)
                .accountType(Account.AccountType.TYPE_2)
                .cashCard(true)
                .smsNotification(true)
                .balanceChangeNotification(true);

        return accountBuilder.build();
    }
}
