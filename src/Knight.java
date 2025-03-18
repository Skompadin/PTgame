public class Knight extends Charakter {

    private int armor;

    public Knight(String name, String job, int str, int dex, int intel, int chp, int mhp, int lvl, int soulz, int cfocus, int mfocus, int hpPotion, int fPotion, int armor) {
        super(name, job, str, dex, intel, chp, mhp, lvl, soulz, cfocus, mfocus, hpPotion, fPotion);
        this.armor = armor;
    }

    @Override
    public String toString() {
        return getName() + " the " + getJob();
    }
    public int getdmg(){
        int dmg;
        dmg = 2*getStr()  +  getDex()  +  getIntel()/2;


        return dmg;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
