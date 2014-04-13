package tests.rover.moving;

import static org.hamcrest.MatcherAssert.assertThat;
import static rover.location.Orientation.SOUTH;
import static tests.MatchersFactory.isLocatedAt;
import static tests.RoverBuilder.aRover;

import org.junit.Before;
import org.junit.Test;

import rover.Rover;
import rover.World;
import rover.worlds.InfiniteWorld;

public class WhenFacingSouth {

    private Rover rover;
    private World world;

    @Before
    public void setUp() {
        world = new InfiniteWorld();
        rover = aRover().at(0, 0).in(world).facing(SOUTH).build();
    }

    @Test
    public void forwards() {
        rover.receive("f");

        assertThat(rover, isLocatedAt(0, -1, SOUTH, world));
    }

    @Test
    public void backwards() {
        rover.receive("b");

        assertThat(rover, isLocatedAt(0, 1, SOUTH, world));
    }
}
