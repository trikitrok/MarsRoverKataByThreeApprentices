package tests.rover.moving;

import static org.junit.Assert.assertTrue;
import static rover.location.Orientation.EAST;
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

    @Before
    public void setUp() {
        world = new InfiniteWorld();
        rover = aRover().at(0, 0).in(world).facing(EAST).build();
    }

    @Test
    public void forwards() {
        rover.receive("f");

        assertTrue(rover.at(new Location(new Position(1, 0), EAST, world)));
    }

    @Test
    public void backwards() {
        rover.receive("b");

        assertTrue(rover.at(new Location(new Position(-1, 0), EAST, world)));
    }
}
