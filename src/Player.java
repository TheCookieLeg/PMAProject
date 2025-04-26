public class Player {
    private String name;

    private static final int MAX_HEALTH = 20;

    private static int health = 20;
    private static int strength = 15;

    public static int getStrength() {
        return strength;
    }

    public static int getHealth() {
        return health;
    }

    public static void RestoreHealth() {health = MAX_HEALTH;}

    public static void takeDamage(int damage) {
        health -= damage;
    }
}
