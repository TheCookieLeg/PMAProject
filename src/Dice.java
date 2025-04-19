import java.io.Serializable;
import java.util.Scanner;
import java.util.Random;

public class Dice {

    public static int Roll(int amount) {
        int successes = 0;
        //Random rand = new Random();
        //return rand.nextInt(6) + 1;
        for (int i = 0; i < amount + 1; i++) {
            Random rand = new Random();
            int result = rand.nextInt(6) + 1;
            if (result > 4) {
                successes += 1;
            }
        }
        return successes;
    }
}
