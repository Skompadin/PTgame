// Wip don't look
// class for knight to upgrade to once upgrade is fully implemented
public class Paladin extends Knight{
    private int faith;
    private int invocations;

    public Paladin(String name, String job, int str, int dex,
                   int intel, int chp, int mhp, int lvl,
                   int soulz, int cfocus, int mfocus,
                   int hpPotion, int mhPotion, int fPotion,
                   int mfPotoin, int maxPotions, boolean upgradeItem,
                   Map world, int armor, int faith, int invocations) {
        super(name, job, str, dex, intel, chp, mhp, lvl, soulz, cfocus, mfocus,
              hpPotion, mhPotion, fPotion, mfPotoin, maxPotions, upgradeItem, world, armor);
        this.faith = faith;
        this.invocations = invocations;
    }

    public int getFaith() {
        return faith;
    }

    public void setFaith(int faith) {
        this.faith = faith;
    }

    public int getInvocations() {
        return invocations;
    }

    public void setInvocations(int invocations) {
        this.invocations = invocations;
    }
}
