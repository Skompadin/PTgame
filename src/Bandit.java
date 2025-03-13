public class Bandit extends Charakter {


    private int doge;

    public Bandit(String name, String job, int str, int dex, int intel, int chp, int mhp, int lvl, int soulz, int cfocus, int mfocus, int hpPotion, int fPotion, int doge) {
        super(name, job, str, dex, intel, chp, mhp, lvl, soulz, cfocus, mfocus, hpPotion, fPotion);
        this.doge = doge;
    }

    public String toString() {
        return getName() + " the " + getJob();
    }
}
