package PlateGame;

import java.util.Random;
import java.util.Scanner;

import Stack.Stack;

public class PlateGame {
  public static void main(String[] args) {
    Random random = new Random();
    boolean onGame = true;
    String gameMessage = "";

    Scanner reader = new Scanner(System.in);

    System.out.println("Plate Game!!");
    System.out.println("=========================================================");

    System.out.println("how many washers ? ex(1, 2)");
    int washersCount = reader.nextInt();
    System.out.println("=========================================================");

    System.out.println("what is the maximum number of the stack ? ex(10, 15)");
    int maximumStack = reader.nextInt();
    System.out.println("=========================================================");

    Washer[] washers = Washer.createWashers(washersCount);
    Stack dishStack = new Stack();

    while (onGame) {
      int roundDishes = random.nextInt(10);
      int washedDishes = 0;

      for (int i = 0; i < roundDishes; i++) {
        dishStack.add("PRATO");
      }

      System.out.println("round dishes: " + roundDishes);
      System.out.println("total dishes : " + dishStack.getSize());

      for (Washer washer : washers) {
        washedDishes += washer.getPlatesToWash();
        dishStack.removeBySize(washer.getPlatesToWash());
      }

      System.out.println("washed dishes: " + washedDishes);
      System.out.println("remaining dishes : " + dishStack.getSize());
      System.out.println("==========================================");

      if (dishStack.getSize() >= maximumStack) {
        gameMessage = "you lost, the maximum number of dishes has been reached";
        onGame = false;
      } else if (dishStack.getSize() == 0) {
        gameMessage = "you win, no plates left";
        onGame = false;
      }
    }

    System.out.println(gameMessage);

  }
}
