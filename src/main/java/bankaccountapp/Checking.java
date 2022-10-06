package bankaccountapp;

public class Checking extends Account{
    private final String debitCard;
    private final int accessToDebitCard;
    private static long id = 100000000000L;

    public Checking(String name, String socialSecurityNumber, String accountType, int initialDeposit) {
        super(name, socialSecurityNumber, accountType, initialDeposit);
        this.debitCard = String.valueOf(id++);
        this.accessToDebitCard = generatePin();
    }

    private int generatePin(){
        return (int)(Math.random()*9999+1000);
    }

    @Override
    public String toString() {
        return "Checking{" +
                "debitCard='" + debitCard + '\'' +
                ", accessToDebitCard=" + accessToDebitCard +
                ", name='" + name + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", initialDeposit=" + initialDeposit +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
