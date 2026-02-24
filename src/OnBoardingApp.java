import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class OnBoardingApp {
    public static void main(String[] args){


        //Collecting...
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter your ID Number: ");
            int idNumber = sc.nextInt();
            System.out.println("Enter your Card Number: ");
            int cardNumber = sc.nextInt();
            System.out.println("Enter your First Name: ");
            String firstName = sc.next();
            System.out.println("Enter your Last Name: ");
            String lastName = sc.next();
            System.out.println("Enter your age: ");
            int age = sc.nextInt();
            System.out.println("Enter your PIN: ");
            int Pin = sc.nextInt();

            Client client = new Client();
            Card card = new Card();
            //Verify PIN

            //Displaying Profile etc...

            int choice = 0;
            while (choice != 5) {
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
                        //       * client.Display();
                        break;
                    case 2:
                        System.out.println("*****  Balance *****");
                        break;
                    case 3:
                        System.out.println("*****  Deposit *****");
                        break;
                    case 4:
                        System.out.println("*****  Withdraw *****");
                        break;
                    case 5:
                        System.out.println("*****  Update PIN *****");
                        System.out.println("Enter your old PIN.");
                        int OldPin = sc.nextInt();
                        System.out.println("Enter your new PIN.");
                        int NewPin = sc.nextInt();
                        card.UpDatePin(OldPin, NewPin);
                        break;
                    case 6:

                        System.out.println("Thank You! Goodbye!");
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