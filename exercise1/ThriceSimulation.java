import java.util.Scanner;

public class ThriceSimulation {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int tallyTotal = 0;

    for (int j = 0; j < 1000; j++) {
      int die1 = (int) (Math.random()*6 + 1);
      int die2 = (int) (Math.random()*6 + 1);
      int die3 = (int) (Math.random()*6 + 1);

      int tally = die1 + die2 + die3;

      int rollCounter = 2;

      //TURN 1//
      while (die1 != die2 || die2 != die3) {
        die1 = (int) (Math.random()*6 + 1);
        die2 = (int) (Math.random()*6 + 1);
        die3 = (int) (Math.random()*6 + 1);

        if (rollCounter % 3 == 0) {
          tally -= (die1 + die2 + die3);
        } else {
          tally += (die1 + die2 + die3);
        }

        rollCounter ++;
      }

      int tripletWorth = die1;

      for (int i = 0; i < tripletWorth; i++) {
        die1 = (int) (Math.random()*6 + 1);
        die2 = (int) (Math.random()*6 + 1);
        die3 = (int) (Math.random()*6 + 1);

        tally += (die1 * die2 * die3);
      }

      boolean finalTripletRolled = false;
      int currentPower = 0;

      while (!finalTripletRolled) {
        die1 = (int) (Math.random()*6 + 1);
        die2 = (int) (Math.random()*6 + 1);
        die3 = (int) (Math.random()*6 + 1);

        if (die1 == die2 && die2 == die3) {
          if (die1 == tripletWorth) {
            tally = tally * 3;
            finalTripletRolled = true;
            break;
          } else {
            tally = die1;
            finalTripletRolled = true;
            break;
          }
        } else {
          tally += Math.pow(3, currentPower);
        }
        currentPower ++;
      }

      tallyTotal += tally;
      System.out.println(tally);
    }

    System.out.println("tally average = " + (tallyTotal / 1000));
  }
}
