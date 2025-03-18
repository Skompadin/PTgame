import java.util.Scanner;
public class Test {

    public static int action(Stage b,Charakter pchar) {
        Scanner sc = new Scanner(System.in);
       if (b.isPyre()){
           System.out.println("1: Rest");
           System.out.println("2: Travel");
       }

        System.out.println("What do you want to do ?");
        System.out.println("1: Explore");
        System.out.println("2: Search Area");
        System.out.println("3: Consume Potion");

        if (b.isPyre()) {
            System.out.println("4: Rest");
        }

        int a = sc.nextInt();

        if (a==3){
            potionchoice(pchar);
        }


        return sc.nextInt();
    }

    public static int potionchoice(Charakter p){
        Scanner sc = new Scanner(System.in);
        System.out.println("1: HP Potion (you have:"+ p.getHpPotion()+")" );
        System.out.println("2: HP Potion (you have:"+ p.getfPotion()+")" );
        System.out.println("3: Back");
        int t = sc.nextInt();
        if (t==1){
            p.setHpPotion(p.getHpPotion()-1);
            p.setChp(p.getChp()+100);
        }else if (t==2){
            p.setfPotion(p.getfPotion()-1);
            p.setCfocus(p.getCfocus()+100);
        }else{

        }
        return t;

        }


    public static void consumepotion(Charakter p){

    }

    public static void raisestr(Charakter pchar){
        pchar.setStr(pchar.getStr()+5);
        pchar.setMhp(pchar.getStr()*10+100);

    }



}
