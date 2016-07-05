package client.changeStructs;

/**
 * Created by squeaky on 7/3/16.
 */
public class AttackChanges {
    boolean unitDied;
    long damageTaken;

    public boolean isUnitDead() {
        return unitDied;
    }

    public void setUnitDied(boolean unitDied) {
        this.unitDied = unitDied;
    }

    public long getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(long damageTaken) {
        this.damageTaken = damageTaken;
    }

}
