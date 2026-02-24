

//BASE CARD CLASS
public class Card {
//    PRIVATE VARIABLES
    private String CardNumber;
    private double Balance;
    private int Pin;
    private boolean IsActive;

//=============DEFAULT CONSTRUCTOR===============================
    public Card()
    {
        this.CardNumber = "0";
        this.Balance = 0.0;
        this.Pin = 0;
        this.IsActive = false;
    }

//============PARAMETERIZED CONSTRUCTOR=========================
    public Card(String CNum, double bal, int pin, boolean status){
        this.CardNumber =CNum;
        this.Balance = bal;
        this.Pin = pin;
        this.IsActive = status;

    }
// =========================CARD===============================
//  SETTER
    public void SetCardNumber( String CNum ){
        this.CardNumber = CNum;
    }

//    GETTER
    public String GetCardNumber(){
        return this.CardNumber;
    }

//=========================BALANCE==============================
//    SETTER
    public void SetBalance(double balance){
        this.Balance = balance;
    }

//    GETTER
    public double GetBalance(){
        return this.Balance;
    }


    //=========================PIN====================================
//    SETTER
    public void SetPin(int pin){
        this.Pin = pin;
    }

//    GETTER
    public int GetPin(){
        return this.Pin;
    }

//===========================IS ACTIVE=========================
//    SETTER
    public void SetStatus(boolean status){
        this.IsActive = status;
    }

//    GETTER
    public boolean GetStatus(){
        return this.IsActive;
    }

//==========================DISPLAY METHOD===================
    public void Display(){
        System.out.println(";Card Number is: " + CardNumber);
        System.out.println("Balance is: " + Balance);
        System.out.println("Pin: " + Pin);
        System.out.println("Status: " + (IsActive ? "Active" : "Inactive"));
    }

//=========================SECURITY METHOD=====================
    public void UpDatePin(int OldPin, int NewPin){
        if(OldPin == this.Pin)
        {
          this.Pin = NewPin;
          System.out.println("+**********Pin Updated Successfully****************");
        }
        else
        {
            System.out.println("*******Incorrect Old PIN. Update Failed.*********");
        }
    }

//=======================ACTIVATE CARD METHOD=================
    public void ActivateCard(){
        //sets card status to true and display conformation message
        this.IsActive = true;
        System.out.println("******** Card is now activated *******");
    }

    @Override
    public String toString() {
        // mask PIN with asterisks
        String maskedPin = "*".repeat(String.valueOf(Pin).length());

        return "Card Summary:\n" +
                "Card Number: " + CardNumber + "\n" +
                "Balance: $" + Balance + "\n" +
                "PIN: " + maskedPin + "\n" +
                "Status: " + (IsActive ? "Active" : "Inactive");
    }

}


