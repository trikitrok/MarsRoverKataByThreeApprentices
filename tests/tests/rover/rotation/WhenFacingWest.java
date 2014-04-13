package tests.rover.rotation;

import static org.junit.Assert.assertTrue;
import static rover.location.Orientation.NORTH;
import static rover.location.Orientation.SOUTH;
import static rover.location.Orientation.WEST;
import static tests.rover.RoverBuilder.aRover;

import org.junit.Before;
import org.junit.Test;

import rover.Location;
import rover.Rover;
import rover.World;
import rover.location.Position;
import rover.worlds.InfiniteWorld;

public class WhenFacingWest {

    private Rover rover;
    private Position initialPositon;
    private World world;

    @Before
    public void setUp() {
        initialPositon = new Position(0, 0);
        world = new InfiniteWorld();
        rover = aRover().at(initialPositon).in(world).facing(WEST).build();
    }

    @Test
    public void left() {
        rover.receive("l");

        assertTrue(rover.at(new Location(initialPositon, SOUTH, world)));
    }

    @Test
    public void right() {
        rover.receive("r");

        assertTrue(rover.at(new Location(initialPositon, NORTH, world)));
    }
}
