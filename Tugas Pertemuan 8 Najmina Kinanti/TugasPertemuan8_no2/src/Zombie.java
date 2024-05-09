import java.util.IllegalFormatCodePointException;

public class Zombie extends Entity{

    enum Types {
        MELEE,
        RANGED
    }

    private Types type;

    public Zombie(int level, int hp, Types type){
        super(level, hp);
        this.type = type;
    }

    @Override
    public void entityInfo() {
        System.out.println("# ZOMBIE DENGAN TIPE : " + type + ", DAN LEVEL : " + getLevel());
    }

    public int damage(Types attack){
        int kerusakan = 0;
        if (attack == Types.MELEE){
            kerusakan = 20;
        } else {
            kerusakan = 15;
        }
        return kerusakan;
    }
    public void attack(Player player){
        if (isAlive()){
            if (player.isAlive()){
                player.setHp(player.getHp() - damage(type));
                System.out.println("player : UGHH");
                if (!player.isAlive()){
                    System.out.println("# YOU DIE, GAME OVER");
                }
            }
        } else {
            System.out.println("# ZOMBIE SUDAH MATI");
        }
    }
}
