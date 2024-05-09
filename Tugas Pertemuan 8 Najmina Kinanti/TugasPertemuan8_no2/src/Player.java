import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {

    private String name;
    private List<Merchant> merchants = new ArrayList<>();

    public Player(int level, int hp, String name){
        super(level, hp);
        this.name = name;
    }

    @Override
    public void entityInfo() {
        System.out.println("# PLAYER DENGAN NAMA : " + name + ", DAN LEVEL : " + getLevel());
    }

    public void interact(Merchant merchant){
        if (isAlive()){
            if (merchant.getHp() == 0){
                System.out.println("# TIDAK BISA BELI, MERCHANT NGAMBEK");
            } else {
                System.out.println("Merchant : ");
                System.out.println("Barang yang tersedia hari ini");
                for (String item : merchant.getListItem()){
                    System.out.println("# " + item);
                }
            }
        } else {
            System.out.println("# PLAYER SUDAH MATI");
        }
    }

    public void attack(Merchant merchant) {
        if (isAlive()){
            if (merchant.isAlive()){
                merchant.setHp(merchant.getHp()-10);
                System.out.println("Merchant : Hey heyy, ngapain nyerang");
                if (merchant.getHp() == 0){
                    System.out.println("Merchant : Dah lah males jualan");
                }
            }
        } else {
            System.out.println("# PLAYER SUDAH MATI");
        }
    }

    public void attack(Zombie zombie){
        if (isAlive()) {
            if (zombie.isAlive()){
                zombie.setHp(zombie.getHp() - 10);
                System.out.println("zombie : GRAAA!");
                if (zombie.getHp() == 0){
                    System.out.println("# ZOMBIE MATI");
                }
            } else {
                System.out.println("ZOMBIE SUDAH MATI");
            }
        } else {
            System.out.println("# PLAYER SUDAH MATI");
        }
    }
}
