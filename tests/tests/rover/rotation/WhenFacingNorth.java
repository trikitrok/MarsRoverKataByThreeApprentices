package tests.rover.rotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static rover.location.Orientation.EAST;
import static rover.location.Orientation.NORTH;
import static rover.location.Orientation.WEST;
import static tests.MatchersFactory.isLocatedAt;
import static tests.RoverBuilder.aRover;

import org.junit.Before;
import org.junit.Test;

import rover.Rover;
import rover.World;
import rover.location.Position;
import rover.worlds.InfiniteWorld;

public class WhenFacingNorth {

    private Rover rover;
    private Position initialPositon;
    private World world;

    @Before
    public void setUp() {
        initialPositon = new Position(0, 0);
        world = new InfiniteWorld();
        rover = aRover().at(initialPositon).in(world).facing(NORTH).build();
    }

    @Test
    public void left() {
        rover.receive("l");

        assertThat(rover, isLocatedAt(initialPositon, WEST, world));
    }

    @Test
    public void right() {
        rover.receive("r");

        assertThat(rover, isLocatedAt(initialPositon, EAST, world));
    }
}
