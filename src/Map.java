public class Map {

    private Stage home;
    private Stage lvlone;
    private Stage lvltwo;
    private Stage place;


    public Map(Stage home, Stage lvlone, Stage lvltwo) {
        this.home = home;
        this.lvlone = lvlone;
        this.lvltwo = lvltwo;
        this.place = home;
    }

    public Stage getHome() {
        return home;
    }

    public void setHome(Stage home) {
        this.home = home;
    }

    public Stage getLvlone() {
        return lvlone;
    }

    public void setLvlone(Stage lvlone) {
        this.lvlone = lvlone;
    }

    public Stage getLvltwo() {
        return lvltwo;
    }

    public void setLvltwo(Stage lvltwo) {
        this.lvltwo = lvltwo;
    }

    public Stage getPlace() {
        return place;
    }

    public void setPlace(Stage place) {
        this.place = place;
    }
}
