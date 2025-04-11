import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Menu {
    //Charakter generation
    public static Charakter chargen(Map world){

        Scanner sc = new Scanner(System.in);

        String name;
        System.out.println("Name your Character");
        name = sc.nextLine();

        int choice;
        ArrayList<Charakter> pc = new ArrayList<>();
        do {
            System.out.println("Chose your Class:");
            System.out.println("1:Knight");
            System.out.println("2:Bandit");
            System.out.println("3:Mage");
            choice=sc.nextInt();
            if (choice != 1 && choice != 2 && choice != 3){ System.out.println("Try again");}
        } while (choice != 1 && choice != 2 && choice != 3);

        if (choice == 1) {
            Knight pchar = new Knight(name,"Knight",30, 20, 10, 500, 500, 0, 200, 200, 200, 5,5,3,3,8,false,world,20);
            pc.add(pchar);
        } else if (choice == 2) {
            Bandit pchar = new Bandit(name,"Bandit", 20, 25, 15, 350, 350, 0, 200, 250, 250, 4,4,4,4,8,false,world,20);
            pc.add(pchar);
        } else {
            Mage pchar = new Mage(name,"Mage",15, 20, 30, 300, 300, 0, 200, 300, 300, 3,3,5,5,8,false,world,15);
            pc.add(pchar);
        }
        return pc.get(0);
    }
        //moving between stages
    public static void travel(Charakter player){
        System.out.println("Where are your travels lead you");
        System.out.println("Select Stage");
        System.out.println("1: Firebound Temple (Home)");
        System.out.println("2: Undead Castle " + player.getWorld().getLvlone().getstatus());
        System.out.println("3: Filth City " + player.getWorld().getLvltwo().getstatus());
        Scanner sc = new Scanner(System.in);
        int stage = sc.nextInt();
        if (stage==1){
            player.getWorld().setPlace(player.getWorld().getHome());
        } else if (stage == 2 ) {
            if(player.getWorld().getPlace() != player.getWorld().getLvlone())player.getWorld().getPlace().setCencounter(0);
            player.getWorld().setPlace(player.getWorld().getLvlone());
        }else {
            if(player.getWorld().getPlace() != player.getWorld().getLvltwo())player.getWorld().getPlace().setCencounter(0);
            player.getWorld().setPlace(player.getWorld().getLvltwo());
        }

    }
        //choose actions in combat
    public static int  combatmenu1 (Charakter player){
        int action;
        Scanner sc = new Scanner(System.in);
        do {
        System.out.println("1 Attack");
        System.out.println("2 Skill");
        System.out.println("3 Potions");

        action = sc.nextInt();
        if (action!=1 && action!=2 && action!=3){
            System.out.println("Not valid option try again");
        }

        }while(action!=1 && action!=2 && action!=3);
        return action;
    }

        //drink potions to restore health or focus
    public static boolean potionchoice(Charakter player){
        Scanner sc = new Scanner(System.in);
        boolean end;
        System.out.println(" ");
        System.out.println("1: Health Potion ( "+player.getHpPotion()+" )");
        System.out.println("2: Focus Potion ( "+player.getfPotion()+" )");
        System.out.println("3: Back");
        int potion = sc.nextInt();
        if(potion==1){

                if (player.getHpPotion()>0){
                    player.setHpPotion(player.getHpPotion()-1);
                    player.potionheal();
                    end =true;
                }else{
                    System.out.println("You are out of Health Potions");
                    end=false;
                }
        } else if (potion == 2) {
                if(player.getfPotion() > 0) {
                    player.setfPotion(player.getfPotion()- 1);
                    player.potionfocus();
                    end=true;
                }else{
                    System.out.println("You are out of Focus Potions");
                    end=false;}

        }else{
            end=false;
        }

        return end;
        }



            //opens menus depended on stage
    public static void placemenu(Charakter player){
        if (player.getWorld().getPlace() ==player.getWorld().getHome() ){

            stagemenuhome(player);
        } else {

          nothomemenu(player);
        }

    }
        //menu for stages that are not the home stage
    public static void nothomemenu(Charakter player) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What do you want to do ?");
        System.out.println("1: Explore (Fight an enemy,Progress the Stage)");
        System.out.println("2: Search the area");
        System.out.println("3: Travel (go to another Stage, reset Stage progress)");
        int i = sc.nextInt();


        if (i == 1) {
            System.out.println(" ");
            System.out.println("You follow the path further until you encounter an enemy defend yourself!");
            System.out.println(" ");
            Combat.fight(player);

        } else if (i == 2) {
            search(player);
        } else {
            travel(player);
        }
    }

        // in a stage that is not the home stage find some exp
        // or get attacked
    public static void search(Charakter player){
        Random rn = new Random();
        int find = rn.nextInt(100) + 1;
        if (find>20){
            System.out.println("You stumble upon an enemy");
            Combat.fight(player);
        }else {
            System.out.println("You find 300 Soulz");
            player.setSoulz(player.getSoulz()+300);
        }


    }

        // opens menu when on home stage
    public static void stagemenuhome(Charakter player){
        Scanner sc = new Scanner(System.in);

        System.out.println("What do you want to do ?");

        System.out.println("1: Rest (Heal up,Lvlup,Customize Potions)");
        System.out.println("2: Travel (go to another Stage reset Stage progress)");
        System.out.println("3: Search the Tempelgrounds(WIP)");//wip
        System.out.println("4: Quit ");
        boolean back = false;
        int a = sc.nextInt();


        if (a == 1) {
                restmenu(player);
            } else if (a == 2) {
                travel(player);
            } else if (a == 3) {
                homesearch(player);
            } else {
                player.setExit(true);
            }
        }
        // when conditions are met player can upgrade their class for exaple
        // from Knight to Paladin (wip)
    public static Charakter homesearch(Charakter player){
        Scanner sc = new Scanner(System.in);
        Charakter pc;
        if (player instanceof Knight){
            System.out.println("You find an old Shrine to a long forgotten God. ");
            System.out.println("1: Pray");
            System.out.println("2: Back");
        }else if (player instanceof Bandit){
            System.out.println("You find a ornate hidden Chest with a strong lock on it. ");
            System.out.println("1: Open the Chest");
            System.out.println("2: Back");
        }else{
            System.out.println("You find old Book with letters that seem older that time itself");
            System.out.println("1: Read the Book");
            System.out.println("2: Back");
        }
        int a = sc.nextInt();
        if (a==1){
            if (player instanceof Knight){
                    if (player.isUpgradeItem()){
                        System.out.println("You hear a soft but stern voice in your head: ");
                        System.out.println("Thou that hath befall upon mine shrine" );
                        System.out.println("and hath returned to me what is rightfully mine" );
                        System.out.println("art chosen to carry mine light into the land that hath forgotten it.");
                        System.out.println("Take up thy sword an vanquish the darkness that hath choked the light from this world.");
                        System.out.println("With mine blessing as thy strength and mine light as thy guide");
                        System.out.println("thou shall shatter the eternal night thou and shall see the sun rise once again");
                        System.out.println(" ");
                        System.out.println("You have become a Paladin bound to the Goddess of light and vengeance ");
                        System.out.println(" Your might has increased");
                        pc = new Paladin(player.getName(),"Paladin", player.getStr(), player.getDex(), player.getIntel(), player.getChp(), player.getMhp(),
                                                player.getLvl(), player.getSoulz(), player.getCfocus(), player.getMfocus(), player.getHpPotion(), player.getMhPotion(), player.getfPotion(),
                                                player.getMfPotion(), player.getMaxPotions(),false,player.getWorld(), ((Knight) player).getArmor(), 5,5);
                        System.out.println();
                    }else{
                        pc = player;
                        System.out.println("Your prayers remain unheard maybe something is missing");
                    }
            }else if (player instanceof Bandit){
                    if (player.isUpgradeItem()){

                        System.out.println("bla bla");
                    }





            }else {
                System.out.println("You find old Book with letters that seem older that time itself");
                System.out.println("1: Read the Book");
                System.out.println("2: Back");
            }



        }


        return pc;

    }
    //when rest gets choosen in menu on home stage
    //player focus and Hp get restored
    public static void restmenu(Charakter player){
        Scanner sc = new Scanner(System.in);
        player.setCfocus(player.getMfocus());
        player.setChp(player.getMhp());
        // restore potions
        boolean end = false;
        //
        do{
            System.out.println("1: Lvl Up");
            System.out.println("2: Split your Potions");
            System.out.println("3: Back");
            int a = sc.nextInt();
            if (a==1){
                lvlup(player);
            } else if (a==2) {
                player.potionconfig();
            }else {
                end = true;
            }
        }while(end == false);
    }
    // attribute increases are bought for souls
    // every increase raises the lvl which raises the costs
    public static void lvlup(Charakter p){
        Scanner sc = new Scanner(System.in);
        boolean close = false;
        do{
            int cost = (p.getLvl()*20)+100;
            System.out.println(p.getName() + " the "+ p.getJob() + " is Level: "+ p.getLvl() + " and has: " + p.getSoulz() + " Soulz" );
            System.out.println("Next Increase will cost " + cost + " Soulz");
            System.out.println("What Stat do you want to increase?");

            System.out.println(" ");
            System.out.println("1 Str: "+ p.getStr());
            System.out.println("2 Int: "+ p.getIntel());
            System.out.println("3 Dex: "+ p.getDex());
            System.out.println("4 Back");
            int a = sc.nextInt();
            if(a<4){
                if (cost <= p.getSoulz()) {
                    p.setLvl(p.getLvl() + 1);
                    System.out.println(p.getName()+ "'s Level has increased by 1 from" + (p.getLvl()-1) + "to"+ p.getLvl());
                    if (a == 1) {
                        p.setStr(p.getStr() + 1);
                        p.setMhp(p.getMhp()+10);
                        p.setChp(p.getMhp());
                        if (p instanceof Knight){((Knight) p).setArmor(((Knight) p).getArmor()+1);}
                        System.out.println("Strength has been increased by 1 from " + (p.getStr()-1)+" to " + p.getStr());
                    } else if (a == 2) {
                        p.setIntel(p.getIntel() + 1);
                        p.setMfocus(p.getMfocus()+20);
                        System.out.println("Intelligence has been increased by 1 from " + (p.getIntel()-1)+" to " + p.getIntel());
                        if (p instanceof Mage){((Mage) p).setRegen(((Mage) p).getRegen()+1);}
                    } else if (a == 3) {
                        p.setDex(p.getDex() + 1);
                        System.out.println("Dexterity has been increased by 1 from " + (p.getDex()-1)+" to " + p.getDex());
                        if (p instanceof Bandit){((Bandit) p).setDoge(((Bandit) p).getDoge()+1);}
                    }
                    p.setSoulz(p.getSoulz()-cost);
                }else{
                    System.out.println("Not enough Soulz");
                }
            }else {close = true;}

        }while (close=false);

    }
public void logo(){
           /*









            */

}
}

