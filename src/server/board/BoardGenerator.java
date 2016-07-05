package server.board;

import client.GameState;
import client.GameStateMap;
import enums.GroundType;
import server.utils.Coordinates;
import structs.RandomSet;

/**
 * Created by squeaky on 7/5/16
 */
public class BoardGenerator {
    int width, height, percentFilled;

    public BoardGenerator(int width, int height) {
        this(width, height, 5);
    }

    public BoardGenerator(int width, int height, int percentFilled) {
        this.width = width;
        this.height = height;
        this.percentFilled = percentFilled;
    }

    public GameStateMap generate() {
        GameStateMap map = new GameStateMap(width, height);

        int onePlayerTotal = Math.max((width * height) / (100 / percentFilled), 1);

        int totalFilled = 0;
        int halfHeight = (height / 2);
        int squaresIn = width / 4; //Yep.  This method will need to be more elegant if it ever goes to prod.

        RandomSet<Coordinates> set = new RandomSet<>();
        set.add(new Coordinates(squaresIn, halfHeight));

        Coordinates currentCoordinates;
        while(totalFilled < onePlayerTotal) {
            currentCoordinates = set.getNext();
            map.setGroundAt(currentCoordinates.getY(), currentCoordinates.getX(), GroundType.EARTH);
            map.setGroundAt((height - currentCoordinates.getY() - 1), (width - currentCoordinates.getX() - 1), GroundType.EARTH);

            addSurrounding(currentCoordinates.getX(), currentCoordinates.getY(), set, map);
            totalFilled++;
        }

        return map;
    }

    private void addSurrounding(int x, int y, RandomSet<Coordinates> toBeFilled, GameStateMap map) {
        //North
        if(y != 0 && map.getGroundAt(x, y - 1) != GroundType.EARTH) {
            toBeFilled.add(new Coordinates(x, y - 1));
        }

        //South
        if(y != width - 1 && map.getGroundAt(x, y + 1) != GroundType.EARTH) {
            toBeFilled.add(new Coordinates(x, y + 1));
        }

        //West
        if(x != 0 && map.getGroundAt(x - 1, y) != GroundType.EARTH) {
            toBeFilled.add(new Coordinates(x - 1 , y));
        }

        //East
        if(x != height - 1 && map.getGroundAt(x + 1, y) != GroundType.EARTH) {
            toBeFilled.add(new Coordinates(x + 1 , y));
        }
    }
}
