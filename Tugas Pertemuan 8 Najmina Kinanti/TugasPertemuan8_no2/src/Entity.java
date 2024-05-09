import java.security.PublicKey;

public class Entity {

    private int level;
    private int hp;

    public Entity(int level, int hp){
        this.level = level;
        this.hp = hp;
    }

    public void entityInfo(){
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive(){
        if (getHp() > 0){
            return true;
        } else {
            return false;
        }
    }
}
