import java.util.Random;

public class Mob {

    private int mobsoulz;
    private String name;
    private int str;
    private int hp;
    private int lvl;
    private boolean charged;

    public Mob(String name, int str, int hp, int lvl) {
        this.name = name;
        this.str = str;
        this.hp = hp;
        this.lvl = lvl;
    }

    public static Mob mobgen(Charakter player){
        String name ="Husk";
        int hp = 0;
        int str=0;
        int lvl = 0;
        int count =player.getWorld().getPlace().getCencounter();
        if (player.getWorld().getPlace().getName()=="Undead Castle"){
            name = "Husk";
            hp = 400+(count*50);
            str = 50 + (count*10);
            lvl = 1;
        }else{
            name = "Guhl";
            hp = 800+(count*50);
            str = 150 + (count*10);
            lvl = 2;
        }

     Mob mob1 =new Mob(name,str,hp,lvl);
        mob1.setMobsoulz((mob1.lvl*200)+(player.getWorld().getPlace().getCencounter()*20));
        return mob1;
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

    public void setHp(int dmg) {
        if (this.hp - dmg < 0){
            this.hp = 0;
        }else {
            this.hp = this.hp - dmg;}
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

    public boolean isCharged() {
        return charged;
    }

    public void setCharged(boolean charged) {
        this.charged = charged;
    }

    public static void mobattack(Charakter player, Mob mob1,boolean def){
        Random rn = new Random();
        int charge = rn.nextInt(100) + 1;

        if(charge<21){
            System.out.println(mob1.getName()+"prepares for an powerfull swing!");
            mob1.setCharged(true);
        }else{
            if (player instanceof Knight ){
                Knight.defKnight(player,mob1,def);
            } else if (player instanceof Bandit) {
                Bandit.defBandit(player,mob1,def);
            }else{
                Mage.defMage(player,mob1,def);
            }
        }





    }
}
