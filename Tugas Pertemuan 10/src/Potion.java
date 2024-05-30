public class Potion extends Item implements IAttack{
    private int duration;
    private int effectPoint;
    private Type type;

    enum Type {
        ATTACK,
        HEAL
    }

    public Potion(String name, String rank, double price, int duration, int effectPoint, Type type) {
        this.name = name;
        this.rank = rank;
        this.price = price;
        this.duration = duration;
        this.effectPoint = effectPoint;
        this.type = type;
    }

    public String use() {
        if (type == Type.ATTACK) {
            return attack();
        } else if (type == Type.HEAL) {
            return heal();
        } else {
            return "Invalid potion type";
        }
    }

    @Override
    public String attack() {
        return "Damage dealt by " + effectPoint;

    }

    public String heal() {
        return "Healed by " + effectPoint;
    }
}

