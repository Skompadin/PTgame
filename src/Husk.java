public class Husk {

    private int mobsoulz;
    private String name;
    private int str;
    private int hp;
    private int lvl;

    public Husk(String name, int str, int hp, int lvl) {
        this.name = name;
        this.str = str;
        this.hp = hp;
        this.lvl = lvl;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobsoulz() {
        return mobsoulz;
    }

    public void setMobsoulz(int mobsoulz) {
        this.mobsoulz = mobsoulz;
    }
}
