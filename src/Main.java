import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    //create Stages
        Stage ft = new Stage("Firebound Temple",0,true,0,true);
        Stage uc = new Stage("Undead Castle",1,false,5,false);
        Stage fc = new Stage("Filth City",2,false,7,false);
        //fill the world with stages to be used as Charter attribute for navigation
        Map world = new Map (ft,uc,fc);

    // Character generation
    ArrayList<Charakter> pc = new ArrayList<>();
    pc.add(Menu.chargen(world));
    Charakter player = pc.get(0);



        do {

            System.out.println("You are at "+ player.getWorld().getPlace().getName());
            System.out.println(" ");
            System.out.println(player.getName() +" the "+ player.getJob()+ " Hp: " + player.getChp() +" Focus:"+player.getCfocus());
            System.out.println(" ");
            Menu.placemenu(player);

        }while(!player.isExit());
    }
}