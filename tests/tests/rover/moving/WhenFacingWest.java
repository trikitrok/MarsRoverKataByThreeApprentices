package tests.rover.moving;

import static org.hamcrest.MatcherAssert.assertThat;
import static rover.location.Orientation.WEST;
import static tests.MatchersFactory.isLocatedAt;
import static tests.RoverBuilder.aRover;

import org.junit.Before;
import org.junit.Test;

import rover.Rover;
import rover.World;
import rover.worlds.InfiniteWorld;

public class WhenFacingWest {

    private Rover rover;
    private World world;

    @Before
    public void setUp() {
        world = new InfiniteWorld();
        rover = aRover().at(5, 5).in(world).facing(WEST).build();
    }

    @Test
    public void forwards() {
        rover.receive("f");

        assertThat(rover, isLocatedAt(4, 5, WEST, world));
    }

    @Test
    public void backwards() {
        rover.receive("b");

        assertThat(rover, isLocatedAt(6, 5, WEST, world));
    }
}
