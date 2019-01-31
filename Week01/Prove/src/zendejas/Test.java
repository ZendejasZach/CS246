package zendejas;

// needed for user input
import java.util.Scanner;

import static zendejas.NSALoginController.hashUserPassword;
import static zendejas.NSALoginController.verifyPassword;

public class Test {

    // initiate the scanner
    private static final Scanner _scanner = new Scanner (System.in);

    private static void printUser(User user){
        System.out.print("\nPassword: ");
        System.out.print(user.getPassword());
        System.out.print("\n");
        System.out.print("\tHash: ");
        System.out.print(user.getHashedPassword());
        System.out.print("\n");
        System.out.print("\tSalt: ");
        System.out.print(user.getSalt());
        System.out.print("\n");
    }

    // Main
    public static void main(String[] args) throws Exception {
        // Prompt user
        System.out.print("Please enter your password: ");

        // get input
        String userPassword = _scanner.next();

        //Create new user
        User user = new User(userPassword);

        // Print user information
        System.out.format("\nUser information before processing:\n");
        printUser(user);

        // call hash user password
        hashUserPassword(user);

        // Print user info after processing
        System.out.format("\nUser information after processing:\n");
        printUser(user);

        // Enter password
        System.out.print("Please verify your password: ");
        String verifyPassword = _scanner.next();
        user.setPassword(verifyPassword);

        // Verify password
        if(verifyPassword(user)){
            System.out.print("Passwords match!\n");
        }
        else{
            System.out.print("Passwords do not match!\n");
        }

    }
}
