package interactables.units;

import abilities.Ability;

import java.util.List;

/**
 * Created by squeaky on 6/29/16.
 */
public interface Unit {
    public long getMaxHealth();
    public long getAttack();
    public long getArmor();
    public boolean isLandSwitcher();
    public List<Ability> getAbilities();
}
