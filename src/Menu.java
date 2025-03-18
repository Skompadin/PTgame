import java.util.ArrayList;
import java.util.Scanner;
public class Menu {

    public static Charakter chargen(){

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
            Knight pchar = new Knight(name,"Knight",20, 15, 10, 300, 300, 0, 200, 200, 200, 4,2,10);
            pc.add(pchar);
        } else if (choice == 2) {
            Bandit pchar = new Bandit(name,"Bandit", 15, 20, 10, 250, 250, 0, 200, 250, 250, 3,3,10);
            pc.add(pchar);
        } else {
            Mage pchar = new Mage(name,"Mage", 10, 15, 20, 200, 200, 0, 200, 300, 300, 2,4,10);
            pc.add(pchar);
        }
        return pc.get(0);
    }

    public static int selectstage(Stage uc, Stage fc){
        System.out.println("Select Stage");
        System.out.println("1: Firebound Temple (Home)");
        System.out.println("2: Undead Castle " + uc.getstatus());
        System.out.println("3: Filth City " + fc.getstatus());
        Scanner sc = new Scanner(System.in);
        int stage = sc.nextInt();
        return stage;
    }

    public static int  combatmenu1 (Charakter player){

        Scanner sc = new Scanner(System.in);
        System.out.println("1 Attack");
        System.out.println("2 Skill");
        System.out.println("3 Potions");

        int action = sc.nextInt();
        return action;
    }

    public static int stagemenuhome(Stage s, Charakter p){
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do ?");

        System.out.println("1: Rest");
        System.out.println("2: Travel");
        System.out.println("3: Search the Tempelgrounds");

        int a = sc.nextInt();
        return a;
    }

    public static void stageactionrest(Charakter p){
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        do{
            System.out.println("1: Lvl Up");
            System.out.println("2: Split your Potions");
            System.out.println("3: Back");
            int a = sc.nextInt();
            if (a==1){
                lvlup(p);
            } else if (a==2) {
                //conigpotion();
            }else {
                end = true;
            }

        }while(end);
    }

    public static void lvlup(Charakter p){
        Scanner sc = new Scanner(System.in);
        boolean close = false;
        do{
            int cost = p.getLvl()*20+100;
            System.out.println(p.getName() + " the "+ p.getJob() + " is Level: "+ p.getLvl() + " and has: " + p.getSoulz() + " Soulz" );
            System.out.println("Next Increase will cost " + cost + " Soulz");
            System.out.println("What Stat do you want to increase?");

            System.out.println(" ");
            System.out.println("1 Str: "+ p.getStr());
            System.out.println("2 Int: "+ p.getIntel());
            System.out.println("3 Dex: "+ p.getDex());
            if(p instanceof Knight){
                System.out.println("4 Protection: "+ ((Knight)p).getArmor());
            } else if (p instanceof Bandit) {
                System.out.println("4 Doge: "+ ((Bandit)p).getDoge());
            }else {
                System.out.println("4 Absorption: "+ ((Mage)p).getRegen());
            }
            System.out.println("5 Back");
            int a = sc.nextInt();
            if(a < 5) {
                if (cost <= p.getSoulz()) {
                    p.setLvl(p.getLvl() + 1);
                    if (a == 1) {
                        p.setStr(p.getStr() + 1);
                    } else if (a == 2) {
                        p.setIntel(p.getIntel() + 1);
                    } else if (a == 3) {
                        p.setDex(p.getDex() + 1);
                    } else if (a == 4) {
                        if (p instanceof Knight) {
                            ((Knight) p).setArmor(((Knight) p).getArmor() + 1);
                        } else if (p instanceof Bandit) {
                            ((Bandit) p).setDoge(((Bandit) p).getDoge() + 1);
                        } else {
                            ((Mage) p).setRegen(((Mage) p).getRegen() + 1);
                        }

                    }

                }else{
                    System.out.println("Not enough Soulz");
                }
            }else {close = true;}

        }while (close);

    }



















}
