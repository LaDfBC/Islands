package interactables.units;

import abilities.Ability;

import java.util.List;

/**
 * Created by squeaky on 6/29/16
 */
public class HuRecruit implements Unit {
    @Override
    public long getMaxHealth() {
        return 0;
    }

    @Override
    public long getAttack() {
        return 0;
    }

    @Override
    public long getArmor() {
        return 0;
    }

    @Override
    public boolean isLandSwitcher() {
        return false;
    }

    @Override
    public List<Ability> getAbilities() {
        return null;
    }
}
