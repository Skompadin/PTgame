import java.util.Scanner;
public class Combat {


    public static boolean fight(Charakter player, Stage ort) {

        Husk husk1 = new Husk("Husk", 10, 200, ort.getLvl());
        boolean dead = false;

        try {

            do {
                //ini
                boolean menuend = false;
                do {
                    int menu1 = Menu.combatmenu1(player);

                    if (menu1 == 1) {
                        husk1.setHp(husk1.getHp() - player.basicAttack(player));
                        System.out.println(player.getName() + " attacks " + husk1.getName() + " for " + player.basicAttack(player) + " damage. ");
                        menuend = true;
                    } else if (menu1 == 2) {
                        //skillmenu
                    } else {
                        int p = Test.potionchoice(player);
                        if (p < 3) {
                            menuend = true;
                        }
                    }
                } while (menuend);

                System.out.println(" ");
                Thread.sleep(2000);

                if (husk1.getHp() > 0) {
                    System.out.println(husk1.getName() + " attacks " + player.getName() + " for " + husk1.getStr() + " Damage");
                    player.setChp(player.getChp() - husk1.getStr());

                    Thread.sleep(2000);

                    System.out.println(player.getName() + " Hp: " + player.getChp() + "  --------  " + husk1.getName() + " HP: " + husk1.getHp());
                } else {
                }

            } while (player.getChp() > 0 && husk1.getHp() > 0);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return dead;
    }
}