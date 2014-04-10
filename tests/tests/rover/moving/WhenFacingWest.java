package tests.rover.moving;

import static org.junit.Assert.assertEquals;

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
    public void forwards() {
        rover.receive("f");

        assertEquals(new Rover(new Location(new Position(4, 5), Orientation.WEST, world),
                signalsToCommands), rover);
    }

    @Test
    public void backwards() {
        rover.receive("b");

        assertEquals(new Rover(new Location(new Position(6, 5), Orientation.WEST, world),
                signalsToCommands), rover);
    }

    private Rover rover;
    private World world;
    private SignalsToCommandsTable signalsToCommands;

    @Before
    public void setUp() {
        signalsToCommands = new SignalsToCommandsTable();
        world = new InfiniteWorld();
        rover = new Rover(new Location(new Position(5, 5), Orientation.WEST, world),
                signalsToCommands);
    }
}
