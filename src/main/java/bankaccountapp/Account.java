package bankaccountapp;

import java.util.List;
import java.util.Random;

public abstract class Account implements IBaseRate {
    protected final String name;
    protected final String socialSecurityNumber;
    protected final String accountType;
    protected double  balance;
    private static int id = 10000;
    protected double rate;
    protected final String accountNumber;

    public Account(String name, String socialSecurityNumber, String accountType, int initDeposit) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.accountType = accountType;
        this.balance = initDeposit;
        id++;
        this.accountNumber = generateAccountNumber();
        setRate();
    }

    private String generateAccountNumber(){
        StringBuilder stringBuilder = new StringBuilder();
        if (this.accountType.equalsIgnoreCase("savings")) {
            stringBuilder.append("1");
        } else {
            stringBuilder.append("2");
        }
        stringBuilder.append(this.socialSecurityNumber.substring(this.socialSecurityNumber.length() - 2));
        stringBuilder.append(id);
        stringBuilder.append((int) (Math.random()* 899 + 100));
        return stringBuilder.toString();
    }

    public String showInfo() {
        return null;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }


    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", rate=" + rate +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

    public void transfer(String name, double amount){
        balance = balance - amount;
        System.out.println("Transferring money to " + name);
    }

    public void withdraw(double amount){
        balance = balance - amount;
    }
    public void deposit(double amount){
        balance = balance + amount;
    }

   public abstract void setRate();
}