package client;

import enums.GroundType;
import interactables.units.Unit;

import java.util.List;

/**
 * Created by squeaky on 6/29/16.
 */
public class GameStateMap {
    public final GroundType[][] ground;
    public final Unit[][] units;

    public GameStateMap(int mapX, int mapY) {
        ground = new GroundType[mapX][mapY];
        units = new Unit[mapX][mapY];

        for(int x = 0; x < mapX; x++) {
            for(int y = 0; y < mapY; y++) {
                ground[x][y] = GroundType.WATER;
                units[x][y] = null;
            }
        }
    }

    public void setGroundAt(int x, int y, GroundType type) {
        ground[x][y] = type;
    }

    public Unit getUnitAt(int x, int y) {
        return units[x][y];
    }

    public GroundType getGroundAt(int x, int y) {
        return ground[x][y];
    }
}
