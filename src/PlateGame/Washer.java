package PlateGame;

import java.util.Random;

public class Washer {
  private int platesToWash;

  public Washer(int platesToWash) {
    this.platesToWash = platesToWash;
  }

  public int getPlatesToWash() {
    return platesToWash;
  }

  public void setPlatesToWash(int platesToWash) {
    this.platesToWash = platesToWash;
  }

  public static Washer[] createWashers(int size) {
    Random random = new Random(); 
    Washer[] washers = new Washer[size];

    for (int i = 0; i < washers.length; i++) {
      int randomValue = random.nextInt(5);

      if (randomValue == 0) {
        washers[i] = new Washer(1);
      } else {
        washers[i] = new Washer(randomValue);
      }
    }
    return washers;
  }

}
