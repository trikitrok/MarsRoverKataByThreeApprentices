package tests.world;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import rover.Obstacles;
import rover.Position;
import rover.World;
import rover.worlds.SquaredWorld;

public class WithObstacles {

    @Test
    public void atGivenPosition() {
        assertTrue(world.hasObstacleAt(positionWithOstacle));
    }

    @Test
    public void notAtGivenPosition() {
        assertFalse(world.hasObstacleAt(new Position(0, 0)));
    }

    World world;
    Position positionWithOstacle;

    @Before
    public void setUp() {
        positionWithOstacle = new Position(1, 1);
        world = new SquaredWorld(2, new Obstacles(positionWithOstacle));
    }
}
