package tests.rover.moving;

import static org.hamcrest.MatcherAssert.assertThat;
import static rover.location.Orientation.EAST;
import static tests.MatchersFactory.isLocatedAt;
import static tests.RoverBuilder.aRover;

import org.junit.Before;
import org.junit.Test;

import rover.Rover;
import rover.World;
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

        assertThat(rover, isLocatedAt(1, 0, EAST, world));
    }

    @Test
    public void backwards() {
        rover.receive("b");

        assertThat(rover, isLocatedAt(-1, 0, EAST, world));
    }
}
