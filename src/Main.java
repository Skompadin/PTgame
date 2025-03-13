import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

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
        // ((Cat) animal).meow();
       // Charakter pchar = pc.get(0);
        //int dmg = ((Knight)pchar).getdmg();


        Stage ft = new Stage("Firebound Temple",0,true,0,true);
        Stage uc = new Stage("Undead Castle",1,false,5,false);
        Stage fc = new Stage("Filth City",2,false,7,false);

        ArrayList<Stage> Stages = new ArrayList<>();
        Stages.add(ft);
        Stages.add(uc);
        Stages.add(fc);

        int stage = Test.selectstage(uc,fc) -1;
        System.out.println("You are at "+Stages.get(stage).getName());

        int a = Test.action(Stages.get(stage),pc.get(0));



    }
}