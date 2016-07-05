package client;


import client.changeStructs.AttackChanges;
import interactables.units.Unit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by squeaky on 7/3/16
 *
 * Defines the various functions and actions that can be taken by a player
 */
public class GameState {
    GameStateMap stateMap;
    Map<Integer, Unit> existingUnits;

    public GameState(int x, int y) {
        stateMap = new GameStateMap(x, y);
        existingUnits = new HashMap<>();
    }

    public AttackChanges executeUnitAttack(Integer attackingUnitId, Integer defendingUnitId) {
        AttackChanges changes = new AttackChanges();
        Unit defender = existingUnits.get(defendingUnitId);
        long incoming = existingUnits.get(attackingUnitId).getAttack();
        if(incoming > defender.getMaxHealth() + defender.getArmor()) {
            changes.setUnitDied(true);
            changes.setDamageTaken(incoming);
        } //TODO: Else

        return changes;
    }
}
