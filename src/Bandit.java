import java.util.Random;
import java.util.Scanner;
public class Bandit extends Charakter {


    private int doge;

    public Bandit(String name, String job, int str, int dex, int intel, int chp, int mhp, int lvl, int soulz, int cfocus,
                  int mfocus, int hpPotion, int mhPotion, int fPotion, int mfPotoin, int maxPotions, boolean upgradeItem, Map world, int doge) {
        super(name, job, str, dex, intel, chp, mhp, lvl, soulz, cfocus, mfocus, hpPotion, mhPotion, fPotion, mfPotoin, maxPotions, upgradeItem, world);
        this.doge = doge;
    }

    public String toString() {
        return getName() + " the " + getJob();
    }

    public int getDoge() {
        return doge;
    }

    public void setDoge(int doge) {
        this.doge = doge;
    }

    //menu that opens in combat when playing as Bandit
    public boolean skillmenuBandit(Charakter player, Mob mob1){
        Scanner sc = new Scanner(System.in);
        boolean def = false;
        System.out.println("1: Doge(defensive skill)");
        System.out.println("2: Twinstrike (70fp)");
        System.out.println("3: Hidden Blade (90fp)");
        int a = sc.nextInt();

        if (a == 1){
            def=true;
            System.out.println(player.getName() + " concentrates on avoiding the next attack");
            }else if (a==2){
            if (player.getCfocus()>69){
                twinstrike(player, mob1);
                player.setCfocus(player.getCfocus()-70);
            }else {
                System.out.println("You tryed to use a skill but lost your Turn ");
            }
                }else{
            if (player.getCfocus()>89){
                    hiddenblade(player, mob1);
                player.setCfocus(player.getCfocus()-90);
            }else {
                System.out.println("You tryed to use a skill but lost your Turn ");
            }
                }
        return def;
    }
        //Character gets hit and some modifier get applied based on skills used
        //when def gets set true by using the defensive skill in combat
        //dodge chance gets increased but never over 90%
    public static void defBandit(Charakter player,Mob mob1,boolean def){
        Random rn = new Random();
        int hit = rn.nextInt(100) + 1;

        int dmg = mob1.getStr();
        if (mob1.isCharged()){dmg=dmg*2;}
        int avoid = ((Bandit)player).getDoge();
        if (def){avoid=avoid*4;}

        if (hit>avoid || hit>90){
            System.out.println(mob1.getName() + " attacks " + player.getName() + " for " + dmg + " Damage");
            player.setChp(player.getChp() - dmg);
        }else{
            System.out.println(player.getName() + " has dodged " + mob1.getName() + "'s attack and took no Damge");
        }

    }



        // Combat Skill for Bandit hits twice and is more likely to crit but at lower base dmg
    public void twinstrike(Charakter player, Mob bla) {
        int mod = 3;
        boolean didcrit = crit(mod);
        double dmg1 = player.basicAttack(player)*0.8;
        int dmg = (int)dmg1;

        if (didcrit) {
            dmg = dmg*2;
            System.out.println(player.getName() + " attacks " + bla.getName() + " for " + dmg + " critical damage. ");
            bla.setHp(dmg);
        }else {
            System.out.println(player.getName() + " attacks " + bla.getName() + " for " + dmg + " damage. ");
            bla.setHp(dmg);
        }
        if (didcrit) {
            dmg = dmg*2;
            System.out.println(player.getName() + " attacks again " + bla.getName() + " for " + dmg + " critical damage. ");
            bla.setHp(dmg);
        }else {
            System.out.println(player.getName() + " attacks again " + bla.getName() + " for " + dmg + " damage. ");
            bla.setHp(dmg);
        }
    }
        // Combat skill for Bandit base dmg but high chance of crit
    public void hiddenblade(Charakter player, Mob bla){
        int mod = 5;
        boolean didcrit = crit(mod);
        int dmg = player.basicAttack(player);
        if (didcrit) {
            dmg = dmg*2;
            System.out.println(player.getName() + " attacks with a hidden Blade " + bla.getName() + " for " + dmg + " critical damage. ");
            bla.setHp(dmg);
        }else {
            System.out.println(player.getName() + " attacks with a hidden Blade " + bla.getName() + " for " + dmg + " damage. ");
            bla.setHp(dmg);
    }

    }
    }
