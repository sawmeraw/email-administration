package emailapp;

import java.util.Random;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    final int defaultPasswordLength = 12;
    private int mailboxLimit = 500;
    private String email;
    private String recoveryEmail;
    final String companySuffix = "stockify.com.au";

    public Email(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
        System.out.println("EMAIL TO CREATE FOR: " + this.firstName.toLowerCase() + " " + this.lastName.toLowerCase());
        this.department = setDepartment();
        System.out.println("Department: " + this.department);
        this.email = createEmail();
        this.password = generatePassword(defaultPasswordLength);
        System.out.println("Password: " + this.password);
    }

    private String setDepartment(){
        System.out.println("SEE CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for Others\nENTER CODE BELOW:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch(choice){
            case 1:
                return "sales";
            case 2:
                return "development";
            case 3:
                return "accounting";
            default:
                return "";
        }
    }

    private String generatePassword(int length){
        int ASCII_HI = 126;
        int ASCII_LO = 32;
        String password = "";
        Random rd = new Random();
        for(int i=0; i<length; i++){
            password += (char) (ASCII_LO + rd.nextInt(ASCII_HI - ASCII_LO +1));
        }

        return password;
    }

    private String createEmail(){
        String email = this.firstName.toLowerCase() + "." + this.department + "@" + companySuffix;
        System.out.println("Email created: " + email);
        return email;
    }

    public void setMailboxLimit(int newLimit){
        this.mailboxLimit = newLimit;
        System.out.println("New mailbox capacity: " + newLimit);
    }

    public void setRecoveryEmail(String email){
        this.recoveryEmail = email;
        System.out.println("Recovery email set for " + this.email + "as: " + email);
    }

    public int mailboxCapacity(){
        return this.mailboxLimit;

    }

    public String getRecoveryEmail(){
        return this.recoveryEmail;
    }

    public String getPassword(){
        return this.password;
    }

    public void showInfo(){
        System.out.println( "NAME: " + this.firstName + " " + this.lastName + "\n" +
                "COMPANY EMAIL: " + this.email + "\n" +
                "MAILBOX CAPACITY: " + this.mailboxLimit);

    }
}
