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

    private String generatePassword() {
        // return String.valueOf(firstName.charAt(0) + lastName.charAt(0) + departmentName.charAt(0) + companyName.charAt(0));
        return firstName.substring(firstName.length() - 2) + lastName.substring(lastName.length() - 2) + "_" + ((int)(Math.random()*(301)+100));
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
        this.password = generatePassword();
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
