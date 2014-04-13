package tests.rover.moving;

import static org.hamcrest.MatcherAssert.assertThat;
import static rover.location.Orientation.NORTH;
import static tests.MatchersFactory.isLocatedAt;
import static tests.RoverBuilder.aRover;

import org.junit.Before;
import org.junit.Test;

import rover.Rover;
import rover.World;
import rover.worlds.InfiniteWorld;

public class WhenFacingNorth {

    private Rover rover;
    private World world;

    @Before
    public void setUp() {
        world = new InfiniteWorld();
        rover = aRover().at(0, 1).in(world).facing(NORTH).build();
    }

    @Test
    public void forwards() {
        rover.receive("f");

        assertThat(rover, isLocatedAt(0, 2, NORTH, world));
    }

    @Test
    public void backwards() {
        rover.receive("b");

        assertThat(rover, isLocatedAt(0, 0, NORTH, world));
    }
}
