package tests.rover.rotation;

import static org.junit.Assert.assertTrue;
import static rover.location.Orientation.EAST;
import static rover.location.Orientation.NORTH;
import static rover.location.Orientation.SOUTH;
import static tests.rover.RoverBuilder.aRover;

import org.junit.Before;
import org.junit.Test;

import rover.Location;
import rover.Rover;
import rover.World;
import rover.location.Position;
import rover.worlds.InfiniteWorld;

public class WhenFacingEast {

    private Rover rover;
    private World world;
    private Position initialPositon;

    @Before
    public void setUp() {
        initialPositon = new Position(0, 0);
        world = new InfiniteWorld();
        rover = aRover().at(initialPositon).in(world).facing(EAST).build();
    }

    @Test
    public void left() {
        rover.receive("l");

        assertTrue(rover.at(new Location(initialPositon, NORTH, world)));
    }

    @Test
    public void right() {
        rover.receive("r");

        assertTrue(rover.at(new Location(initialPositon, SOUTH, world)));
    }
}
