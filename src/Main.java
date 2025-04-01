import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    ArrayList<Charakter> pc = new ArrayList<>();
    //Charakter erstellung
    pc.add(Menu.chargen());

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
        Stage cStage = Stages.get(0);
        Charakter player = pc.get(0);
        //int stage = Menu.selectstage(uc,fc) -1;
        //Stage cStage =Stages.get(stage-1);
        System.out.println("You are at "+cStage.getName());

        boolean travel = false;
    do {
        Menu.placemenu(cStage,player,ft,uc,fc);











    }while(travel);




    // while(deadorhome = true)







        //int a = Test.action(Stages.get(stage),pc.get(0));

        //Combat.fight(pc.get(0),uc);


    }
}