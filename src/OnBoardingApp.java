import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OnBoardingApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        boolean authenticated = false;

        //Collecting...
        try {
            System.out.println("Enter your age: ");
            int age = sc.nextInt();
           if (age < 18){
                System.out.println("Client does not meet the age requirements");
                System.exit(0);
            }
            System.out.println("Enter your ID Number: ");
            int idNumber = sc.nextInt();
            System.out.println("Enter your First Name: ");
            String firstName = sc.next();
            System.out.println("Enter your Last Name: ");
            String lastName = sc.next();
            System.out.println("Enter your Card Number: ");
            String cardNumber = sc.next();
            System.out.println("Enter your Initial Deposit Amount: ");
            double bal = sc.nextInt();


            System.out.println("Enter your PIN: ");
            int Pin = sc.nextInt();

            Card card = new Card(cardNumber, bal,Pin);
            Client client = new Client(idNumber,firstName, lastName, age, card);

            //Verify PIN
            while (attempts < 3 && !authenticated) {
                System.out.println("\nEnter Pin to Verify: ");
                int verifyPin = sc.nextInt();

                if (client.GetCard().GetPin() == verifyPin) {
                    System.out.println("\n***** Pin Verified Successfully *****\n");
                    authenticated = true;
                } else {
                    System.out.println("********* Invalid Pin! Try again *********\n");
                    attempts++;

                }
            }

            if (!authenticated){
                System.out.println("***** You've entered the wrong pin too many times ******");
                System.exit(0);
            }

            //Displaying Profile etc...
            System.out.println("ID Number: " + idNumber);
            System.out.println("Client: " + firstName + " " + lastName);
            System.out.println("Card Number: " + cardNumber);
            System.out.println("Pin: " + Pin);
            System.out.println("Balance: " + bal);

            int choice = 0;
            while (choice != 6) {
                System.out.println("\n******  MAIN MENU  ******");
                System.out.println("1. View Client Profile");
                System.out.println("2. View Balance");
                System.out.println("3. Deposit");
                System.out.println("4. Withdraw");
                System.out.println("5. Update PIN");
                System.out.println("6. Exit");
                System.out.println("Selection: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("*****  Client Profile  *****");
                       System.out.println(client);
                       if (!client.GetCard().GetStatus()){ // This checks if card is not active


                           System.out.println("Would you like to activate your account? (y/n)");
                           char cardActivated = sc.next().charAt(0);
                           if (cardActivated == 'y') {
                               client.GetCard().ActivateCard();
                           }
                       }
                        break;
                    case 2:
                        System.out.println("*****  Balance *****");
                        double balanceCheck = client.GetCard().GetBalance();
                        System.out.println("Your balance is $" + balanceCheck);
                        break;
                    case 3:
                        System.out.println("*****  Deposit *****");
                        System.out.println("Enter the amount you wish to deposit: ");
                        double deposit = sc.nextInt();
                        deposit =  deposit + client.GetCard().GetBalance();
                        client.GetCard().SetBalance(deposit);
                        System.out.println("Deposit Successful.");


                        break;
                    case 4:
                        System.out.println("**  Withdraw **");
                        System.out.println("Enter the amount you wish to withdraw: ");
                        double withdraw = sc.nextInt();
                        if  (withdraw <= client.GetCard().GetBalance())
                        {
                            withdraw = client.GetCard().GetBalance() - withdraw;
                            client.GetCard().SetBalance(withdraw);
                            System.out.println("Withdraw Successful.");
                        } else
                        if (withdraw > client.GetCard().GetBalance())
                        {
                            System.out.println("Insufficient Funds! Try Again with lesser Amount! Amount Available $" + client.GetCard().GetBalance());
                        }
                        break;
                    case 5:
                        authenticated = false;
                        attempts = 0;
                        while (attempts < 3 && !authenticated) {
                            System.out.println("*****  Update PIN *****");
                            System.out.println("Enter your old PIN.");
                            int OldPin = sc.nextInt();
                            sc.nextLine(); // clear leftover newline

                            if (OldPin == client.GetCard().GetPin()) {
                                authenticated = true;
                            } else {
                                System.out.println("Incorrect PIN Entered. You have " + (2 - attempts) + " attempts remaining.");
                                attempts++;
                                if (attempts >= 3) {
                                    System.out.println("Error: Incorrect Code Entered Too Many Times. Security Alert Triggered...");
                                    System.exit(0);

                                }
                            }
                        }
                        if(authenticated) {
                            System.out.println("Enter your new PIN.");
                            int NewPin = sc.nextInt();
                            sc.nextLine(); // clear leftover newline

                            client.GetCard().UpDatePin(client.GetCard().GetPin(), NewPin);
                        }
                        break;
                    case 6:

                        System.out.println("Thank You! Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid format. Please try again.");
        }
    }
}
