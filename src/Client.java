public class Client {

    private int idNumber;
    private String firstName;
    private String lastName;
    private  int age;
    private Card card;

  /*  public Client(){
        this.idNumber = 0;
        this.firstName = " ";
        this.lastName = " ";
        this.age = 0;

    }*/ //REMOVE FOR NOW
    /*public Client(int idNumber, String firstName, String lastName, int age,
                  String cardNumber, double balance, int pin, boolean isActive) */ //REMOVE FOR NOW
    public Client(int idNumber, String firstName, String lastName, int age, Card card){

       /* if (age < 18) {
            throw new IllegalArgumentException("Client must be 18 or older.");
        }*/ //REMOVE FOR NOW

        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        //this.card = new Card(cardNumber, balance, pin, isActive);
        this.card = card;
    }

//======================ID NUMBER=================================
//    SETTER
    public void SetIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

//    GETTER
    public int GetIdNumber(){
        return  this.idNumber;
    }

//======================FIRST NAME=================================
//    SETTER
    public void SetFirstName(String firstName) {
        this.firstName = firstName;
    }

//    GETTER
    public String GetFirstName(){
        return this.firstName;
    }

//======================LAST NAME=================================
//    SETTER
    public void SetLastName(String lastName){
        this.lastName = lastName;
    }

//    GETTER
    public String GetLastName(){
        return this.lastName;
    }

//====================== AGE =================================
//    SETTER
    public void SetAge(int age){
        this.age = age;
    }

//    GETTER
    public int GetAge(){
        return this.age;
    }

//====================== CARD =================================
//    SETTER
    public void SetCard(Card card){
        this.card = card;
    }

//    GETTER
    public Card GetCard(){
        return this.card;
    }

//======================DISPLAY METHOD=================================
    public void Display(){
        System.out.println("Client: " + firstName + " " + lastName +
                " (ID: " + idNumber + ", Age: " + age + ")");
        System.out.println("Card Info: " + card);
    }


    @Override
    public String toString() {
        return "Client Information\n" +
                "ID Number: " + idNumber + "\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "Age: " + age + "\n\n" +
                card.toString();
    }
}