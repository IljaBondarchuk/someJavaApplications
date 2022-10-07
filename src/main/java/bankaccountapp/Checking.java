package bankaccountapp;

public class Checking extends Account{
    private final String debitCard;
    private final int accessToDebitCard;
    private static long id = 100000000000L;

    public Checking(String name, String socialSecurityNumber, String accountType, int initDeposit) {
        super(name, socialSecurityNumber, accountType, initDeposit);
        this.debitCard = String.valueOf(id++);
        this.accessToDebitCard = generatePin();
    }

    private int generatePin(){
        return (int)(Math.random()*8999+1000);
    }

    @Override
    public String showInfo() {
        String info = "Checking{" +
                "debitCard='" + debitCard + '\'' +
                ", accessToDebitCard=" + accessToDebitCard +
                ", name='" + name + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", initialDeposit=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance + '\'' +
                ", rate='" + rate + '\'' +
                '}';
        System.out.println(info);
        return info;
    }

    @Override
    public void setRate() {
        rate = getRate()*.15;
    }

}
