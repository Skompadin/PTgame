import java.util.Random;
import java.util.Scanner;

public class Charakter {

    private String name;
    //job has the name of the class like Knight
    private String job;
    private int str;
    private int dex;
    private int intel;
    //Current healthpoint and Maxhealthpoints
    private int chp;
    private int mhp;
    private int lvl;
    //exp currency
    private int soulz;
    //current focus and max focus basically mana
    private int cfocus;
    private int mfocus;
    //health potions current and max same fpr focus potions
    // max for potions carried combined
    private int hpPotion;
    private int mhPotion;
    private int fPotion;
    private int mfPotion;
    private int maxPotions;

    private boolean upgradeItem;
    //has the stages for navigation and current position
    private Map world;
    //ends game if true
    private boolean exit;

    public Charakter(String name, String job, int str, int dex, int intel, int chp, int mhp, int lvl, int soulz,
                     int cfocus, int mfocus, int hpPotion, int mhPotion, int fPotion, int mfPotion, int maxPotions, boolean upgradeItem, Map world) {

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
        this.mhPotion = mhPotion;
        this.fPotion = fPotion;
        this.mfPotion = mfPotion;
        this.maxPotions = maxPotions;
        this.upgradeItem = upgradeItem;
        this.world = world;
    }



    // dmg calculation for basic atk dmg and as base for skill dmg
    // casted into an int to not have awkward hp counts
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
        // using a health potion restores the Characters current hp "chp"
        // but not over the Max hp "mhp"
    public void potionheal() {
        int heal=50;
        if (heal + this.chp > this.mhp) {
            this.chp = this.mhp;
        }   else {this.chp = this.chp+heal;
            }
    }
        // same as potionheal but for focus
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
        // calculation for critikal hits
        // based on dex with a modifiyer for Bandit and some skills
    public boolean crit(int mod){
        Random rn = new Random();
        int crit = rn.nextInt(100) + 1;
        boolean hit =false;
        int chance = getDex()*mod;
        if (chance > 90){chance = 90;}
        if (crit <= chance) {hit = true; }
        return hit;
    }
        // config for potions adjusts amount of health potions
        // and focus potion based on Max potions
    public void potionconfig(){
        Scanner sc = new Scanner(System.in);
        System.out.println("You have " + getMhPotion()+"Health potions and "+ getMfPotion() +"Focus potions");
        System.out.println("You can have" + getMaxPotions() +" choose how many Healh potions you want to have the rest will be Focus Potions");
        int a = sc.nextInt();
        if (a<getMaxPotions()){
            setMhPotion(a);
            setMfPotion(getMaxPotions()- getMhPotion());
        }




    }

    public boolean isUpgradeItem() {
        return upgradeItem;
    }

    public void setUpgradeItem(boolean upgradeItem) {
        this.upgradeItem = upgradeItem;
    }

    public int getMfPotion() {
        return mfPotion;
    }

    public void setMfPotion(int mfPotion) {
        this.mfPotion = mfPotion;
    }

    public int getMhPotion() {
        return mhPotion;
    }

    public void setMhPotion(int mhPotion) {
        this.mhPotion = mhPotion;
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

    public boolean isExit() {return exit;}

    public void setExit(boolean exit) {this.exit = exit;}
}


