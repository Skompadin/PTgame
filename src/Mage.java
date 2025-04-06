import java.util.Random;
import java.util.Scanner;

public class Mage extends Charakter {


    private int regen;

    public Mage(String name, String job, int str, int dex, int intel, int chp, int mhp, int lvl, int soulz, int cfocus, int mfocus, int hpPotion, int fPotion, int maxPotions, Map world, int regen) {
        super(name, job, str, dex, intel, chp, mhp, lvl, soulz, cfocus, mfocus, hpPotion, fPotion, maxPotions, world);
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

    public boolean skillmenuMage(Charakter player, Mob bla){
        Scanner sc = new Scanner(System.in);
        boolean def = false;
        System.out.println("1: Shield");
        System.out.println("2: Soul Blast");
        System.out.println("3: Chaos Barrage");
        int a = sc.nextInt();

        if (a == 1){def=true;
        }else if (a==2){
            soulblast(player, bla);
        }else{
            chaosbarrage(player, bla);
        }
        return def;
    }

    public static void defMage(Charakter player,Mob mob1,boolean def){
        int plusfocus;
        double dmg = mob1.getStr();
        if (mob1.isCharged()){dmg=dmg*2;}
        int admg;
        int absorb = ((Mage)player).getRegen();
        plusfocus = (int)dmg;
        if (def){
            plusfocus=(int)dmg*2;
            dmg = dmg*0.25;
        }
        admg = (int) dmg;


        System.out.println(mob1.getName() + " attacks " + player.getName() + " for " + admg + " Damage");
        System.out.println(player.getName() + "Absorbs some of the hits force and restores " + plusfocus +" Focus");
        player.setCfocus(player.getCfocus()+plusfocus);
        player.setChp(player.getChp() - admg);


    }

    public void soulblast(Charakter player, Mob bla){
        int mod = 1;
        boolean didcrit = crit(mod);
        int dmg = player.basicAttack(player)*2;
        if (didcrit) {
            dmg = dmg*2;
            System.out.println(player.getName() + " casts Soul Blast at" + bla.getName() + " for " + dmg + " critical damage. ");
            bla.setHp(dmg);
        }else {
            System.out.println(player.getName() + " casts Soul Blast at " + bla.getName() + " for " + dmg + " damage. ");
            bla.setHp(dmg);
        }
    }
    public void chaosbarrage(Charakter player, Mob bla){
        Random rn = new Random();
        int blastanzahl = rn.nextInt(player.getIntel()) + 1;


        for (int i = 0; i < blastanzahl ; i++) {
            int blastdmg = rn.nextInt(player.getIntel()) + 1;
            System.out.println(player.getName() + " blasts " + bla.getName() + " for " + blastdmg + " damage. ");
            bla.setHp(blastdmg);
        }



    }






}
