public class Boss extends Mob{

    String loot;

    public Boss(String name, int str, int hp, int lvl, String loot) {
        super(name, str, hp, lvl);
        this.loot = loot;
    }
        // as a last encounter on a stage that is not "home"
        // a stronger enemy gets created
        // also drops item 4 char upgrade (wip)
    public static Boss bossgen(Charakter player){

            String name ="Husk";
            int hp = 0;
            int str=0;
            int lvl = 0;
            String loot;
            if (player instanceof Knight){loot = "Holy relic";
            } else if (player instanceof Mage) {
                loot = "Golden Key";
            }else {loot ="Arcane Lexicon"; }
            if (player.getWorld().getPlace().getName()=="Undead Castle"){
                name = "Minotaur";
                hp = 1000;
                str = 200;
                lvl = 1;
            }else{
                name = "Skeleton Dragon";
                hp = 1800;
                str = 300;
                lvl = 2;
            }

            Boss boss1 =new Boss(name,str,hp,lvl,loot);
            boss1.setMobsoulz((boss1.getLvl()*1500));
            return boss1;
        }


    }






