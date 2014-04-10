package tests.rover.moving;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import rover.Rover;
import rover.World;
import rover.location.Orientation;
import rover.location.Position;
import rover.worlds.InfiniteWorld;

public class WhenFacingEast {

    @Test
    public void forwards() {
        rover.receive("f");

        assertEquals(new Rover(new Position(1, 0), Orientation.EAST, world), rover);
    }

    @Test
    public void backwards() {
        rover.receive("b");

        assertEquals(new Rover(new Position(-1, 0), Orientation.EAST, world), rover);
    }

    private Rover rover;
    private World world;

    @Before
    public void setUp() {
        world = new InfiniteWorld();
        rover = new Rover(new Position(0, 0), Orientation.EAST, world);
    }
}
