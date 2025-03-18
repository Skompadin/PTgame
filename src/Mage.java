public class Mage extends Charakter {


    private int regen;

    public Mage(String name, String job, int str, int dex, int intel, int chp, int mhp, int lvl, int soulz, int cfocus, int mfocus, int hpPotion, int fPotion, int regen) {
        super(name, job, str, dex, intel, chp, mhp, lvl, soulz, cfocus, mfocus, hpPotion, fPotion);
        this.regen = regen;
    }

    public String toString() {
        return getName() + " the " + getJob();
    }

    public int getRegen() {
        return regen;
    }

    public void setRegen(int regen) {
        this.regen = regen;
    }
}
