public class Charakter {

    private String name;
    private String job;
    private int str;
    private int dex;
    private int intel;
    private int chp;
    private int mhp;
    private int lvl;
    private int soulz;
    private int cfocus;
    private int mfocus;
    private int hpPotion;
    private int fPotion;
    private int maxPotions;
    private boolean figthing;

    public Charakter(String name, String job, int str, int dex, int intel, int chp, int mhp, int lvl, int soulz, int cfocus, int mfocus, int hpPotion, int fPotion) {
        this.name = name;
        this.job = job;
        this.str = str;
        this.dex = dex;
        this.intel = intel;
        this.chp = chp;
        this.mhp = str*10+100;
        this.lvl = lvl;
        this.soulz = soulz;
        this.cfocus = cfocus;
        this.mfocus = mfocus;
        this.hpPotion = hpPotion;
        this.fPotion = fPotion;
    }
        //potion lvl




    public int basicAttack(Charakter player){
        double dmg;
        if (player instanceof Knight){
            dmg=player.getStr()*2 +player.getDex()+ player.getIntel()/2;
        } else if (player instanceof Bandit){
            dmg=player.getStr() + player.getDex()*2+ player.getIntel()/2;
        }else{
            dmg=player.getStr()/2 + player.getDex() + player.getIntel()*2;
        }
    int aDmg = (int) dmg;
    return aDmg;
    }

    public int getMhp() {
        return mhp;
    }

    public void setMhp(int mhp) {
        this.mhp = mhp;
    }

    public int getChp() {
        return chp;
    }

    public void setChp(int chp) {
        if (chp + this.chp > this.chp) {
            this.chp = this.mhp;
        } else {this.chp = this.chp+chp;  }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getSoulz() {
        return soulz;
    }

    public void setSoulz(int soulz) {
        this.soulz = soulz;
    }

    public int getCfocus() {
        return cfocus;
    }

    public void setCfocus(int cfocus) {
        this.cfocus = cfocus;
    }

    public int getMfocus() {
        return mfocus;
    }

    public void setMfocus(int mfocus) {
        this.mfocus = mfocus;
    }

    public int getHpPotion() {
        return hpPotion;
    }

    public void setHpPotion(int hpPotion) {
        this.hpPotion = hpPotion;
    }

    public int getfPotion() {
        return fPotion;
    }

    public void setfPotion(int fPotion) {
        this.fPotion = fPotion;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
