package bankaccountapp;

public class Saving extends Account{

    private final int safetyDepositBox;
    private final int accessToSafetyDepositBox;

    private static int id = 100;


    public Saving(String name, String socialSecurityNumber, String accountType, int initDeposit) {
        super(name, socialSecurityNumber, accountType, initDeposit);
        this.safetyDepositBox = id++;
        this.accessToSafetyDepositBox = generatePinCode();
    }

    private int generatePinCode(){
        return (int) (Math.random() * 899 + 100);
    }

    @Override
    public String showInfo() {
        String info = "Saving{" +
                "safetyDepositBox=" + safetyDepositBox +
                ", accessToSafetyDepositBox=" + accessToSafetyDepositBox +
                ", name='" + name + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", initialDeposit=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", rate='" + rate + '\'' +
                '}';
        System.out.println(info);
        return info;
    }

    @Override
    public void setRate() {
       rate = getRate() - .25;
    }
}
