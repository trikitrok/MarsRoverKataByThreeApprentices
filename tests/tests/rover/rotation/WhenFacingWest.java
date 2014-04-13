package tests.rover.rotation;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import rover.Location;
import rover.Rover;
import rover.SignalsToCommandsTable;
import rover.World;
import rover.location.Orientation;
import rover.location.Position;
import rover.worlds.InfiniteWorld;

public class WhenFacingWest {

    @Test
    public void left() {
        rover.receive("l");

        assertTrue(rover.at(new Location(position, Orientation.SOUTH, world)));
    }

    @Test
    public void right() {
        rover.receive("r");

        assertTrue(rover.at(new Location(position, Orientation.NORTH, world)));
    }

    private Rover rover;
    private Position position;
    private World world;
    private SignalsToCommandsTable signalsToCommands;

    @Before
    public void setUp() {
        signalsToCommands = new SignalsToCommandsTable();
        position = new Position(0, 0);
        world = new InfiniteWorld();
        rover = new Rover(new Location(position, Orientation.WEST, world), signalsToCommands);
    }
}
