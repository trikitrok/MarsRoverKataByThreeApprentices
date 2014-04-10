package tests.rover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import rover.Location;
import rover.Rover;
import rover.World;
import rover.location.Orientation;
import rover.location.Position;
import rover.worlds.InfiniteWorld;
import rover.worlds.Obstacles;
import rover.worlds.SquaredWorld;

public class Equality {

    @Test
    public void whenEqual() {
        assertEquals(rover, new Rover(new Location(position, orientation, world)));
    }

    @Test
    public void whenAtDifferentPositions() {
        assertNotEquals(rover, new Rover(new Location(new Position(1, 0), orientation, world)));
        assertNotEquals(rover, new Rover(new Location(new Position(0, 1), orientation, world)));
    }

    @Test
    public void whenHavingDifferentOrientations() {
        assertNotEquals(rover, new Rover(new Location(position, Orientation.NORTH, world)));
    }

    @Test
    public void whenInDifferentWorlds() {
        assertNotEquals(rover, new Rover(new Location(position, orientation, new SquaredWorld(1,
                new Obstacles()))));
    }

    @Before
    public void setUp() {
        world = new InfiniteWorld();
        orientation = Orientation.SOUTH;
        position = new Position(0, 0);
        rover = new Rover(new Location(position, orientation, world));
    }

    private World world;
    private Orientation orientation;
    private Position position;
    private Rover rover;
}
