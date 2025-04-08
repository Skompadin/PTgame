import java.util.Scanner;

public class Knight extends Charakter {
    /**
     * mostly the same as bandit
     */
    private int armor;

    public Knight(String name, String job, int str, int dex, int intel, int chp, int mhp, int lvl, int soulz, int cfocus, int mfocus, int hpPotion, int mhPotion, int fPotion, int mfPotoin, int maxPotions, boolean upgradeItem, Map world, int armor) {
        super(name, job, str, dex, intel, chp, mhp, lvl, soulz, cfocus, mfocus, hpPotion, mhPotion, fPotion, mfPotoin, maxPotions, upgradeItem, world);
        this.armor = armor;
    }

    @Override
    public String toString() {
        return getName() + " the " + getJob();
    }

    public boolean skillmenuKnight(Charakter player, Mob mob1){
        Scanner sc = new Scanner(System.in);
        boolean def = false;
        System.out.println("1: Brace (defensive skill )");
        System.out.println("2: Heavy Blow (50fp)");
        System.out.println("3: Juggernaut (80fp)");
        int a = sc.nextInt();

        if (a == 1){def=true;
        }else if (a==2){
            if (player.getCfocus()>49){
                heavyblow(player, mob1);
                player.setCfocus(player.getCfocus()-50);
            }else {
                System.out.println("You tryed to use a skill but lost your Turn ");
            }

        }else{
            if (player.getCfocus()>79){
            juggernaut(player, mob1);
            player.setCfocus(player.getCfocus()-80);
            }else {
                System.out.println("You tryed to use a skill but lost your Turn ");
            }
        }
        return def;
    }

    public static void defKnight(Charakter player,Mob mob1,boolean def){

        double dmg = mob1.getStr();
        if (mob1.isCharged()){dmg=dmg*2;}
        int prot = ((Knight)player).getArmor()*2;
        if (def){
            dmg=dmg-(dmg/100)*(prot*2);
        }else{dmg=dmg-(dmg/100)*prot;}
        System.out.println(mob1.getName() + " attacks " + player.getName() + " for " + (int)dmg + " Damage");
        player.setChp(player.getChp() - (int)dmg);
    }


    public void heavyblow(Charakter player, Mob mob1){
        int mod = 1;
        boolean didcrit = crit(mod);
        int dmg = player.basicAttack(player)*2;
        if (didcrit) {
            dmg = dmg*2;
            System.out.println(player.getName() + " attacks with a heavy blow " + mob1.getName() + " for " + dmg + " critical damage. ");
            mob1.setHp(dmg);
        }else {
            System.out.println(player.getName() + " attacks with a heavy blow " + mob1.getName() + " for " + dmg + " damage. ");
            mob1.setHp(dmg);
        }
    }
    public void juggernaut(Charakter player, Mob mob1){
        int mod = 1;
        boolean didcrit = crit(mod);
        int dmg = player.basicAttack(player)*2+((Knight) player).getArmor();
        if (didcrit) {
            dmg = dmg*2;
            System.out.println(player.getName() + " attacks " + mob1.getName() + " for " + dmg + " critical damage. ");
            mob1.setHp(dmg);
        }else {
            System.out.println(player.getName() + " attacks " + mob1.getName() + " for " + dmg + " damage. ");
            mob1.setHp(dmg);
        }
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
