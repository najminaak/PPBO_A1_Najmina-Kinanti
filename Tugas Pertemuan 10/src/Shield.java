public class Shield extends Item {
    private int damageBlock;

    public Shield(String name, String rank, double price, int damageBlock) {
        this.name = name;
        this.rank = rank;
        this.price = price;
        this.damageBlock = damageBlock;
    }

    public String defense() {
        return "Damage Mitigated by " + damageBlock;
    }
}
