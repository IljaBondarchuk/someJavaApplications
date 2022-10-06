package bankaccountapp;

import java.util.Random;

public class Account {
    protected final String name;
    protected final String socialSecurityNumber;
    protected final String accountType;
    protected final int  initialDeposit;
    private static int id = 10000;
    protected final String accountNumber;

    public Account(String name, String socialSecurityNumber, String accountType, int initialDeposit) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.accountType = accountType;
        this.initialDeposit = initialDeposit;
        id++;
        this.accountNumber = generateAccountNumber();
    }

    private String generateAccountNumber(){
        StringBuilder stringBuilder = new StringBuilder();
        if (this.accountType.toLowerCase() == "savings" ) {
            stringBuilder.append("1");
        } else {
            stringBuilder.append("2");
        }
        stringBuilder.append(this.socialSecurityNumber.substring(this.socialSecurityNumber.length() - 2));
        stringBuilder.append(id);
        stringBuilder.append((int) (Math.random()* 899 + 100));
        return stringBuilder.toString();
    }


}