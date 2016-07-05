package server;

import client.GameStateMap;
import enums.GroundType;
import org.junit.Test;
import server.board.BoardGenerator;

import static org.junit.Assert.assertEquals;

/**
 * Created by squeaky on 7/5/16
 */
public class BoardGeneratorTest {
    @Test
    public void testBasicGenerator() {
        BoardGenerator generator = new BoardGenerator(3, 3, 10);
        GameStateMap map = generator.generate();

        assertEquals(map.getGroundAt(1, 0), GroundType.EARTH);
    }

    @Test
    public void testNormalGenerator() {
        BoardGenerator generator = new BoardGenerator(5, 5, 10);
        GameStateMap map = generator.generate();

        assertEquals(map.getGroundAt(2, 1), GroundType.EARTH);
    }
}
