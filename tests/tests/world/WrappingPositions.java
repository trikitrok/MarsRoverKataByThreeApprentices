package tests.world;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import rover.Obstacles;
import rover.Position;
import rover.worlds.SquaredWorld;

public class WrappingPositions {

    @Test
    public void alreadyInside() {
        positionInsideWorld = new Position(0, 1);

        assertEquals(positionInsideWorld, world.wrap(positionInsideWorld));
    }

    @Test
    public void overTopEdgeToBottom() {
        positionInsideWorld = new Position(0, 0);

        assertEquals(positionInsideWorld, world.wrap(new Position(0, 2)));
    }

    @Test
    public void overBottomEdgeToTop() {
        positionInsideWorld = new Position(0, 1);

        assertEquals(positionInsideWorld, world.wrap(new Position(0, -1)));
    }

    @Test
    public void overRightEdgeToLeft() {
        positionInsideWorld = new Position(0, 0);

        assertEquals(positionInsideWorld, world.wrap(new Position(2, 0)));
    }

    @Test
    public void overLeftEdgeToRight() {
        positionInsideWorld = new Position(1, 0);

        assertEquals(positionInsideWorld, world.wrap(new Position(-1, 0)));
    }

    private SquaredWorld world;
    private Position positionInsideWorld;

    @Before
    public void setUp() {
        world = new SquaredWorld(2, new Obstacles());
    }
}
