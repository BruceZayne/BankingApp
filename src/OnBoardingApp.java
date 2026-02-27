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
                       System.out.println(client);
                       if (!client.GetCard().GetStatus()){ // Ths checks if card is not active


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
                        System.out.println("*****  Withdraw *****");
                        System.out.println("Enter the amount you wish to withdraw: ");
                        double withdraw = sc.nextInt();
                        withdraw =  client.GetCard().GetBalance() - withdraw;
                        client.GetCard().SetBalance(withdraw);
                        System.out.println("Withdraw Successful.");
                        break;
                    case 5:
                        while (attempts < 3 && !authenticated) {
                            System.out.println("*****  Update PIN *****");
                            System.out.println("Enter your old PIN.");
                            int OldPin = sc.nextInt();
                            if (OldPin == Pin) {
                                authenticated = true;
                            } else {
                                attempts++;
                                if (attempts >= 3) {
                                    System.out.println("Error: Incorrect Code Entered Too Many Times. Security Alert Triggered...");
                                    System.out.close();
                                    System.exit(0);

                                }
                            }
                        }

                        System.out.println("Enter your new PIN.");
                        int NewPin = sc.nextInt();
                        card.UpDatePin(Pin, NewPin);
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