import java.io.Serializable;
import java.util.Scanner;
import java.util.Random;

public class Dice {

    public static int Roll() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;

    }
}
