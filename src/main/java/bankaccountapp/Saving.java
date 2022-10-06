package bankaccountapp;

public class Saving extends Account{

    private final int safetyDepositBox;
    private final int accessToSafetyDepositBox;

    private static int id = 100;


    public Saving(String name, String socialSecurityNumber, String accountType, int initialDeposit) {
        super(name, socialSecurityNumber, accountType, initialDeposit);
        this.safetyDepositBox = id++;
        this.accessToSafetyDepositBox = generatePinCode();
    }

    private int generatePinCode(){
        return (int) (Math.random() * 999 + 100);
    }

    @Override
    public String toString() {
        return "Saving{" +
                "safetyDepositBox=" + safetyDepositBox +
                ", accessToSafetyDepositBox=" + accessToSafetyDepositBox +
                ", name='" + name + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", initialDeposit=" + initialDeposit +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
