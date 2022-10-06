package bankaccountapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BankAccountApp {
    public static void main(String[] args) {
        ArrayList<Account> accountArrayList = new ArrayList<>();
       String line = "";
       String splitBy = ",";
       try {
           BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/NewBankAccounts.csv"));
           while ((line = bufferedReader.readLine()) != null) {
               String [] newAccounts = line.split(splitBy);
               if (newAccounts[2].equalsIgnoreCase("savings")){
                   accountArrayList.add(new Saving(newAccounts[0],newAccounts[1],newAccounts[2],Integer.parseInt(newAccounts[3])));
               } else {
                   accountArrayList.add(new Checking(newAccounts[0], newAccounts[1], newAccounts[2], Integer.parseInt(newAccounts[3])));
               }
           }
       }
       catch (Exception e){
           e.printStackTrace();
       }
    accountArrayList.forEach(System.out::println);
    }
}
