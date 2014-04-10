package tests.rover.rotation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import rover.Rover;
import rover.World;
import rover.location.Orientation;
import rover.location.Position;
import rover.worlds.InfiniteWorld;

public class WhenFacingWest {

    @Test
    public void left() {
        rover.receive("l");

        assertEquals(new Rover(position, Orientation.SOUTH, world), rover);
    }

    @Test
    public void right() {
        rover.receive("r");

        assertEquals(new Rover(position, Orientation.NORTH, world), rover);
    }

    private Rover rover;
    private Position position;
    private World world;

    @Before
    public void setUp() {
        position = new Position(0, 0);
        world = new InfiniteWorld();
        rover = new Rover(position, Orientation.WEST, world);
    }
}
