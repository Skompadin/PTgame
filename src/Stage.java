public class Stage {

    private String name;
    private int lvl;
    private boolean cleared;
    private int encounter;
    private boolean pyre;

    public Stage(String name, int lvl, boolean cleared, int encounter, boolean pyre) {
        this.name = name;
        this.lvl = lvl;
        this.cleared = cleared;
        this.encounter = encounter;
        this.pyre = pyre;
    }

    public String getstatus() {
        String status;
        if (this.cleared == true) {
            status = "(Clear)";
        }else {status="(Uncleared)";}
        return status;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public boolean isCleared() {
        return cleared;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

    public int getEncounter() {
        return encounter;
    }

    public void setEncounter(int encounter) {
        this.encounter = encounter;
    }

    public boolean isPyre() {
        return pyre;
    }

    public void setPyre(boolean pyre) {
        this.pyre = pyre;
    }
}
