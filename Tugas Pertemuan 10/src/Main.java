public class Main {
    public static void main(String[] args) {
        Potion attackPotion = new Potion("Attack Potion", "A", 10.0, 5, 20, Potion.Type.ATTACK);
        Potion healPotion = new Potion("Heal Potion", "B", 15.0, 3, 25, Potion.Type.HEAL);
        Sword sword = new Sword("Excalibur", "S", 50.0, 35);
        Shield shield = new Shield("Dragon Shield", "A", 30.0, 15);

        System.out.println("Potion (Attack):");
        attackPotion.displayInfo();
        System.out.println();

        System.out.println("Potion (Heal):");
        healPotion.displayInfo();
        System.out.println();

        System.out.println("Sword:");
        sword.displayInfo();
        System.out.println();

        System.out.println("Shield:");
        shield.displayInfo();
        System.out.println();

        System.out.println("\nUsing Potion (Attack): " + attackPotion.use());
        System.out.println("Using Potion (Heal): " + healPotion.use());
        System.out.println("Using Sword: " + sword.attack());
        System.out.println("Using Shield: " + shield.defense());
    }
}