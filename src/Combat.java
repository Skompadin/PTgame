import java.util.Random;
import java.util.Scanner;
public class Combat {


    public static void fight(Charakter player) {
    boolean def = false;
    Mob trash = Mob.mobgen(player);
    Boss boss = Boss.bossgen(player);
    Mob mob1;
    //next enemy boss or trash mob
    if(player.getWorld().getPlace().getCencounter()<player.getWorld().getPlace().getEncounter() ||
       player.getWorld().getPlace().isCleared()){
    mob1 = trash;
        }else{
            mob1 =boss;
        }

        try {

            do {
                //ini
                boolean menuend = true;
                do {

                    int menu1 = Menu.combatmenu1(player);

                    if (menu1 == 1) {
                        int mod=1;
                        if(player instanceof Bandit){mod=2;}
                        int dmg = player.basicAttack(player);
                        boolean didcrit= (player.crit(mod));

                        if (didcrit){
                            dmg=dmg*2;
                            System.out.println(player.getName() + " attacks " + mob1.getName() + " for " + dmg + " critical damage. ");
                            mob1.setHp(dmg);
                        }else{
                            System.out.println(player.getName() + " attacks " + mob1.getName() + " for " + dmg + " damage. ");
                            mob1.setHp(dmg);
                        }


                            } else if (menu1 == 2) {
                            if (player instanceof Knight ){
                                def= ((Knight) player).skillmenuKnight(player, mob1);

                            } else if (player instanceof Bandit) {
                                def = ((Bandit) player).skillmenuBandit(player, mob1);
                            }else{
                                def= ((Mage)player).skillmenuMage(player, mob1);
                            }
                    } else {
                        int p = Test.potionchoice(player);
                        if (p < 3) {
                            menuend = false;
                        }
                    }
                } while (menuend == false);

                System.out.println(" ");
                Thread.sleep(2000);

                if (mob1.getHp() > 0) {
                    if (!mob1.isCharged()){
                        Mob.mobattack(player,mob1,def);

                    }else {

                        if (player instanceof Knight) {
                            Knight.defKnight(player, mob1, def);
                        } else if (player instanceof Bandit) {
                            Bandit.defBandit(player, mob1, def);
                        } else {
                            Mage.defMage(player, mob1, def);
                        }
                        mob1.setCharged(false);
                    }
                    Thread.sleep(2000);

                    System.out.println(player.getName() + " Hp: " + player.getChp() + "  --------  " + mob1.getName() + " HP: " + mob1.getHp());
                }

            } while (player.getChp() > 0 && mob1.getHp() > 0);
            if (player.getChp()==0) {
                System.out.println("You Died");
                System.out.println("Your Body reforms at the last place you rested and you lost your souls");
                player.setChp(player.getMhp());
                player.getWorld().setPlace(player.getWorld().getHome());
            }else{
                System.out.println(mob1.getName()+"was defeated you gained "+mob1.getMobsoulz());
                player.setSoulz(player.getSoulz()+ mob1.getMobsoulz());
                player.getWorld().getPlace().setCencounter(player.getWorld().getPlace().getCencounter()+1);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

}