import java.util.ArrayList;
import java.util.Scanner;
public class Menu {

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
            Knight pchar = new Knight(name,"Knight",30, 20, 10, 500, 500, 0, 200, 200, 200, 4,2,10, world,20);
            pc.add(pchar);
        } else if (choice == 2) {
            Bandit pchar = new Bandit(name,"Bandit", 20, 25, 15, 350, 350, 0, 200, 250, 250, 3,3,10,world, 20);
            pc.add(pchar);
        } else {
            Mage pchar = new Mage(name,"Mage", 15, 20, 30, 300, 300, 0, 200, 300, 300, 2,4,10,world,15);
            pc.add(pchar);
        }
        return pc.get(0);
    }

    public static void travel(Charakter player){

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

    public static int  combatmenu1 (Charakter player){

        Scanner sc = new Scanner(System.in);
        System.out.println("1 Attack");
        System.out.println("2 Skill");
        System.out.println("3 Potions");

        int action = sc.nextInt();
        return action;
    }
    public static void potionchoice(Charakter player){
        Scanner sc = new Scanner(System.in);
        System.out.println("1: Health Potion ( "+player.getHpPotion()+" )");
        System.out.println("2: Focus Potion ( "+player.getCfocus()+" )");
        System.out.println("3: Back");
        int potion = sc.nextInt();
        if(potion==1){
            if (player.getHpPotion()>0){
                player.setHpPotion(player.getHpPotion()-1);
                player.potionheal();
            }else {}

        }

    }

    public static void placemenu(Charakter player){
        if (player.getWorld().getPlace() ==player.getWorld().getHome() ){

            stagemenuhome(player);
        } else {

          nothomemenu(player);
        }

    }

    public static void nothomemenu(Charakter player) {
        Scanner sc = new Scanner(System.in);

        boolean exit=false;

        do {
            System.out.println("What do you want to do ?");
            System.out.println("1: Explore");
            System.out.println("2: Search the area");
            System.out.println("3: Travel");
            int i = sc.nextInt();


                if (i == 1) {
                    Combat.fight(player);

                }else if (i == 2){
                    //explore
                }else {travel(player);
                    exit=true;
                }

        }while(exit=false);
    }



    public static void stagemenuhome(Charakter player){
        Scanner sc = new Scanner(System.in);

        System.out.println("What do you want to do ?");

        System.out.println("1: Rest");
        System.out.println("2: Travel");
        System.out.println("3: Search the Tempelgrounds");
        System.out.println("4: Quit ");
        boolean back = false;
        int a = sc.nextInt();
        do {
            if (a == 1) {
                restmenu(player);
            } else if (a == 2) {
                travel(player);
            } else if (a == 3) {
                //upgarde path
            } else {
                //quitgame
            }
        }while(back);
    }

    public static void restmenu(Charakter player){
        Scanner sc = new Scanner(System.in);
        player.setCfocus(player.getMfocus());
        player.setChp(player.getMhp());
        // restore potions
        boolean end = false;
        do{
            System.out.println("1: Lvl Up");
            System.out.println("2: Split your Potions");
            System.out.println("3: Back");
            int a = sc.nextInt();
            if (a==1){
                lvlup(player);
            } else if (a==2) {
                //conigpotion();
            }else {
                end = true;
            }

        }while(end == false);
    }

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
    public static void Upgradepath(Charakter player){
        // knight Shrine / bandit chest / mage book
        if(player instanceof Knight){

        } else if (player instanceof Mage) {

        }else{

        }


        if(player.getWorld().getLvlone().isCleared()){}
    }



















}
