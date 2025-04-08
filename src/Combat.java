import java.util.Random;
import java.util.Scanner;
public class Combat {

        //combat
    public static void fight(Charakter player) {
    boolean def = false;
    // 2 enemy are created a Mob(basic enemy) and a boss(Stronger enemy
        // )
    Mob trash = Mob.mobgen(player);
    Boss boss = Boss.bossgen(player);
    Mob mob1;
    //test for encounter count on current run/stage when threshold reached boss "spawned"
    //if not a normal mod
    if(player.getWorld().getPlace().getCencounter()<player.getWorld().getPlace().getEncounter() ||
       player.getWorld().getPlace().isCleared()){
    mob1 = trash;
        }else{
            mob1 =boss;
        }

        try {

            do {

                boolean menuend = true;
                //in a loop because "back" in potion menu does not cost a turn
                do {
                    //Combat menu opens
                    int menu1 = Menu.combatmenu1(player);
                    // basic attack checks for crits and applys dmg
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

                        // Based on class Skill menu opens

                    } else if (menu1 == 2) {
                            if (player instanceof Knight ){
                                def= ((Knight) player).skillmenuKnight(player, mob1);

                            } else if (player instanceof Bandit) {
                                def = ((Bandit) player).skillmenuBandit(player, mob1);
                            }else{
                                def= ((Mage)player).skillmenuMage(player, mob1);
                            }
                                } else {
                                    Menu.potionchoice(player);
                                }
                } while (menuend == false);

                System.out.println(" ");
                Thread.sleep(2000);



                System.out.println(" ");
                Thread.sleep(2000);
                //check if mob is dead before it hits back
                //also checks if charge attack was used
                if (mob1.getHp() > 0) {
                    if (!mob1.isCharged()){
                        Mob.mobattack(player,mob1,def);

                    }else {
                        //based on class dmg gets calculated and apply
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
                    //combat status
                    System.out.println(player.getName() + " Hp: " + player.getChp() +" Focus:"+player.getCfocus()+ "  --------  " + mob1.getName() + " HP: " + mob1.getHp());
                    System.out.println(" ");
                }
                //combat ends when mob or player dies
            } while (player.getChp() > 0 && mob1.getHp() > 0);
                // combat aftermath if player dies
            if (player.getChp()<1) {
                System.out.println("You Died");
                System.out.println("Your Body reforms at the last place you rested and you lost your souls");
                System.out.println("Your Progress on "+player.getWorld().getPlace()+" was reset");
                player.setChp(player.getMhp());
                player.getWorld().getPlace().setCencounter(0);
                player.getWorld().setPlace(player.getWorld().getHome());
                // combat aftermath if player wins
            }else{
                System.out.println(mob1.getName()+"was defeated you gained "+mob1.getMobsoulz() +" Soulz");
                player.setSoulz(player.getSoulz()+ mob1.getMobsoulz());
                player.getWorld().getPlace().setCencounter(player.getWorld().getPlace().getCencounter()+1);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

}