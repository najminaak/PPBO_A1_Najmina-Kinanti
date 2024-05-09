import java.util.ArrayList;

public class Merchant extends Entity{
    private ArrayList<String> listItem;

    public Merchant(int level, int hp, ArrayList listItem){
        super(level, hp);
        this.listItem = listItem;
    }

    @Override
    public void entityInfo() {
        System.out.println("# PLAYER DENGAN LEVEL: " + getLevel());
    }

    public ArrayList<String> getListItem() {
        return listItem;
    }
}
