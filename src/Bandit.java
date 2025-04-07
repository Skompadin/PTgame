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

    public boolean skillmenuBandit(Charakter player, Mob bla){
        Scanner sc = new Scanner(System.in);
        boolean def = false;
        System.out.println("1: Doge");
        System.out.println("2: Twinstrike");
        System.out.println("3: Hidden Blade");
        int a = sc.nextInt();

        if (a == 1){def=true;
            }else if (a==2){
                twinstrike(player, bla);
                }else{
                    hiddenblade(player, bla);
                }
        return def;
    }

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




    public void twinstrike(Charakter player, Mob bla) {
        int mod = 3;
        boolean didcrit = crit(mod);
        int dmg = player.basicAttack(player);
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
