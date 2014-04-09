package tests.rover.moving;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import rover.Orientation;
import rover.Position;
import rover.Rover;
import rover.World;
import rover.worlds.InfiniteWorld;

public class WhenFacingNorth {

    @Test
    public void forwards() {
        rover.receive("f");

        assertEquals(new Rover(new Position(0, 2), Orientation.NORTH, world), rover);
    }

    @Test
    public void backwards() {
        rover.receive("b");

        assertEquals(new Rover(new Position(0, 0), Orientation.NORTH, world), rover);
    }

    private Rover rover;
    private World world;

    @Before
    public void setUp() {
        world = new InfiniteWorld();
        rover = new Rover(new Position(0, 1), Orientation.NORTH, world);
    }
}
