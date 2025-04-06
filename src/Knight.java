import java.util.Scanner;

public class Knight extends Charakter {

    private int armor;

    public Knight(String name, String job, int str, int dex, int intel, int chp, int mhp, int lvl, int soulz, int cfocus, int mfocus, int hpPotion, int fPotion, int maxPotions, Map world, int armor) {
        super(name, job, str, dex, intel, chp, mhp, lvl, soulz, cfocus, mfocus, hpPotion, fPotion, maxPotions, world);
        this.armor = armor;
    }

    @Override
    public String toString() {
        return getName() + " the " + getJob();
    }

    public boolean skillmenuKnight(Charakter player, Mob mob1){
        Scanner sc = new Scanner(System.in);
        boolean def = false;
        System.out.println("1: Brace");
        System.out.println("2: Heavy Blow");
        System.out.println("3: Juggernaut");
        int a = sc.nextInt();

        if (a == 1){def=true;
        }else if (a==2){
            heavyblow(player, mob1);
        }else{
            juggernaut(player, mob1);
        }
        return def;
    }

    public static void defKnight(Charakter player,Mob mob1,boolean def){

        double dmg = mob1.getStr();
        if (mob1.isCharged()){dmg=dmg*2;}
        int prot = ((Knight)player).getArmor()*2;
        if (def){dmg=dmg-(dmg/100)*(prot*3);
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
            System.out.println(player.getName() + " attacks " + mob1.getName() + " for " + dmg + " critical damage. ");
            mob1.setHp(dmg);
        }else {
            System.out.println(player.getName() + " attacks " + mob1.getName() + " for " + dmg + " damage. ");
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
