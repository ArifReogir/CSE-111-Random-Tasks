/*Write the PlatinumCard and SignatureCard classes derived from CreditCard class so that the following code generates the output below.

Note: 
>Platinum card users initially have 100 reward points and will get 2 reward points for spending 100 taka each.
>Signature card users initially have 200 reward points and will get 4 reward points for spending 100 taka each. 
>Signature card users are allowed to bring upto 5 companions at lounges. */

public class CardTester { // Driver code
  public static void main(String[] args) {
    CreditCard card1 = new PlatinumCard("Ali", "345 127");
    CreditCard card2 = new SignatureCard("Rahul", "514 123");
    CreditCard card3 = new SignatureCard("Rohan", "147 965");
    CreditCard[] cards = { card1, card2, card3 };
    for (int i = 0; i < cards.length; i++) {
      System.out.println("================");
      if (cards[i] instanceof SignatureCard) {
        SignatureCard new_card = (SignatureCard) cards[i];
        new_card.spendCash(500);
      } else if (cards[i] instanceof PlatinumCard) {
        PlatinumCard new_card = (PlatinumCard) cards[i];
        new_card.spendCash(200);
      }
      System.out.println("================");
      cards[i].cardDetails();
    }
  }
}

// Class starts here

class CreditCard { // Parent class
  public String cardHolder;
  public String accountNo;
  public int rewardPoints;

  public CreditCard(String cardHolder, String accountNo, int rewardPoints) {
    this.cardHolder = cardHolder;
    this.accountNo = accountNo;
    this.rewardPoints = rewardPoints;
  }

  public void cardDetails() {
    System.out.println("Card Holder Name: " + cardHolder);
    System.out.println("Account Number: " + accountNo);
    System.out.println("Reward point gained: " + rewardPoints);
  }
}

class PlatinumCard extends CreditCard { // Child class

  public PlatinumCard(String name, String account) {
    super(name, account, 100);
  }

  public void spendCash(int x) {
    System.out.println("Previous Reward Points: " + rewardPoints);
    int earn = (x / 100) * 2;
    rewardPoints += earn;
    System.out.println("Reward points after spending " + x + " taka: " + rewardPoints);
  }
}

class SignatureCard extends CreditCard {

  public SignatureCard(String name, String account) {
    super(name, account, 200);

  }

  public void spendCash(int x) {
    System.out.println("Previous Reward Points: " + rewardPoints);

    int earn = (x / 100) * 4;
    rewardPoints += earn;
    System.out.println("Reward points after spending " + x + " taka: " + rewardPoints);

  }

  public void cardDetails() {
    super.cardDetails();
    System.out.println("Possible Number of Companions for Lounge: 5");
  }
}
