public abstract class Item {
    protected String name;
    protected String rank;
    protected double price;

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Rank: " + rank);
        System.out.println("Price: " + price);
    }
}

