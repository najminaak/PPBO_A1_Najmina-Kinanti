public class Sword extends Item implements IAttack{
    private int damage;

    public Sword(String name, String rank, double price, int damage) {
        this.name = name;
        this.rank = rank;
        this.price = price;
        this.damage = damage;
    }

    @Override
    public String attack() {
        return "Damage dealt by " + damage;
    }
}
