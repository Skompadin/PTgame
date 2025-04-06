import java.util.Random;

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
    private Map world;

    public Charakter(String name, String job, int str, int dex, int intel, int chp, int mhp, int lvl, int soulz,
                     int cfocus, int mfocus, int hpPotion, int fPotion, int maxPotions, Map world) {
        this.name = name;
        this.job = job;
        this.str = str;
        this.dex = dex;
        this.intel = intel;
        this.chp = chp;
        this.mhp = mhp;
        this.lvl = lvl;
        this.soulz = soulz;
        this.cfocus = cfocus;
        this.mfocus = mfocus;
        this.hpPotion = hpPotion;
        this.fPotion = fPotion;
        this.maxPotions = maxPotions;
        this.world = world;
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

    public void potionheal() {
        int heal=50;
        if (heal + this.chp > this.mhp) {
            this.chp = this.mhp;
        }   else {this.chp = this.chp+heal;
            }
    }

    public void potionfocus() {
        int plusfocus=50;
        if (plusfocus + this.cfocus > this.mfocus) {
            this.cfocus = this.mfocus;
        }   else {this.cfocus = this.cfocus+plusfocus;
        }
    }

    public void setChp(int chp) {
        if (this.chp - chp > 0){
        this.chp = chp;
        }else{
            this.chp = 0;
        }

    }

    public boolean crit(int mod){
        Random rn = new Random();
        int crit = rn.nextInt(100) + 1;
        boolean hit =false;
        int chance = getDex()*mod;
        if (chance > 90){chance = 90;}
        if (crit <= chance) {hit = true; }
        return hit;
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

    public Map getWorld() {
        return world;
    }

    public void setWorld(Map world) {
        this.world = world;
    }

    public int getMaxPotions() {
        return maxPotions;
    }

    public void setMaxPotions(int maxPotions) {
        this.maxPotions = maxPotions;
    }





}


