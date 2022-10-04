package emailApp;


import javax.swing.undo.AbstractUndoableEdit;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Email {
    private final String firstName;
    private final String lastName;
    private String departmentName;
    private final String companyName;
    private final String email;
    private String alternateEmail;
    private int mailCapacity;
    private String password;
    private int passwordLength = 10;

    private String generatePasswordDumb() {
        return firstName.substring(firstName.length() - 2) + lastName.substring(lastName.length() - 2) + "_" + ((int)(Math.random()*(301)+100));
    }

    private String generatePassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890#$%!";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return String.valueOf(password);
    }
    public void setMailCapacity(int capacity){
        if (mailCapacity < capacity) {
            mailCapacity = capacity;
        }
    }

    public void setAlternateEmail(){
        System.out.println("Enter your alternate email address:");
        Scanner in = new Scanner(System.in);
        String alternateEmail = in.nextLine();
        this.alternateEmail = alternateEmail;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    @Override
    public String toString() {
        return "Email{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Email(String firstName, String lastName, String departmentName, String companyName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentName = departmentName;
        this.companyName = companyName;
        this.password = generatePassword(passwordLength);
        System.out.println(this.password);
        this.email = generateEmail();
        this.mailCapacity = 50;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void changePassword() {
        System.out.println("Enter your old password:");
        Scanner in = new Scanner(System.in);
        String oldPassword = in.nextLine();
        if (oldPassword.equals(this.password)) {
            System.out.println("Enter your new password:");
            String newPassword = in.nextLine();;
            System.out.println("Repeat it:");
            String checkNewPassword = in.nextLine();
            if (checkNewPassword.equals(newPassword)){
                this.password = newPassword;
                System.out.println("Password changed successful");
            } else {
                System.out.println("Wrong second password!");
                changePassword();
            }
        } else {
            System.out.println("Wrong password");
        }
    }
    public String getPassword() {
        return password;
    }
    public String generateEmail () {
        return  getFirstName().toLowerCase() + "." + getLastName().toLowerCase() + "@" + getDepartmentName().toLowerCase() + "." + getCompanyName().toLowerCase() + ".com";
    }
}
