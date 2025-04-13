public class Player {
    private String name;

    private final int maxHealth = 20;

    private static int health;
    private static int strength;
    private int agility;
    private int intelligence;

    private int coins;

    public static int getStrength() {
        return strength;
    }

    public static int getHealth() {
        return health;
    }

    public static void takeDamage(int damage) {
        health -= damage;
    }
}
