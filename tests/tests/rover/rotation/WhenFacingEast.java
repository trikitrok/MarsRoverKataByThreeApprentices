package tests.rover.rotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static rover.location.Orientation.EAST;
import static rover.location.Orientation.NORTH;
import static rover.location.Orientation.SOUTH;
import static tests.MatchersFactory.isLocatedAt;
import static tests.RoverBuilder.aRover;

import org.junit.Before;
import org.junit.Test;

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

        assertThat(rover, isLocatedAt(initialPositon, NORTH, world));
    }

    @Test
    public void right() {
        rover.receive("r");

        assertThat(rover, isLocatedAt(initialPositon, SOUTH, world));
    }
}
