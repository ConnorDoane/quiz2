import java.util.Scanner;

public class ThriceTurn {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int die1 = (int) (Math.random()*6 + 1);
    int die2 = (int) (Math.random()*6 + 1);
    int die3 = (int) (Math.random()*6 + 1);
    System.out.println(die1 + " " + die2 + " " + die3);
    System.out.println("   add");

    int tally = die1 + die2 + die3;

    int rollCounter = 2;

    //TURN 1//
    while (die1 != die2 || die2 != die3) {
      die1 = (int) (Math.random()*6 + 1);
      die2 = (int) (Math.random()*6 + 1);
      die3 = (int) (Math.random()*6 + 1);
      System.out.println(die1 + " " + die2 + " " + die3);

      if (rollCounter % 3 == 0) {
        System.out.println("   subtract");
        tally -= (die1 + die2 + die3);
      } else {
        System.out.println("   add");
        tally += (die1 + die2 + die3);
      }

      rollCounter ++;
    }

    int tripletWorth = die1;

    for (int i = 0; i < tripletWorth; i++) {
      die1 = (int) (Math.random()*6 + 1);
      die2 = (int) (Math.random()*6 + 1);
      die3 = (int) (Math.random()*6 + 1);

      System.out.println(   "multiply then add");
      System.out.println(die1 + " " + die2 + " "  + die3);

      tally += (die1 * die2 * die3);
    }

    System.out.println("After your first two rounds, your current tally is " + tally + ".");
    System.out.println("Your first triplet rolled was worth " + tripletWorth + ".");
    System.out.println("Press 0 to roll, press 1 to retire");

    int retire = scan.nextInt();

    boolean finalTripletRolled = false;
    int currentPower = 0;

    while (retire == 0 && !finalTripletRolled) {
      die1 = (int) (Math.random()*6 + 1);
      die2 = (int) (Math.random()*6 + 1);
      die3 = (int) (Math.random()*6 + 1);

      System.out.println(die1 + " " + die2 + " " + die3);
      if (die1 == die2 && die2 == die3) {
        if (die1 == tripletWorth) {
          tally = tally * 3;
          finalTripletRolled = true;
          System.out.println("CONGRATULATIONS your tally has been TRIPLED");
          break;
        } else {
          tally = die1;
          finalTripletRolled = true;
          System.out.println("I'm sorry, this is the wrong triplet. Your final tally has been reset.");
          break;
        }
      } else {
        tally += Math.pow(3, currentPower);
      }
      currentPower ++;
      System.out.println("Press 0 to roll again, press 1 to retire. Your current tally is " + tally);
      retire = scan.nextInt();
    }

    System.out.println("Your final tally is " + tally);
  }
}
