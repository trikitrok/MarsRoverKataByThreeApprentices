package tests.rover.moving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rover.Location;
import rover.Rover;
import rover.SignalsToCommandsTable;
import rover.World;
import rover.location.Orientation;
import rover.location.Position;
import rover.worlds.InfiniteWorld;

public class WhenItReceivesNoCommand {

    @Test
    public void staysAtInitialPosition() {
        SignalsToCommandsTable signalsToCommands = new SignalsToCommandsTable();
        World world = new InfiniteWorld();
        Position initialPosition = new Position(1, 0);
        Orientation initialOrientation = Orientation.SOUTH;
        Rover rover = new Rover(new Location(initialPosition, initialOrientation, world),
                signalsToCommands);

        rover.receive("");

        assertEquals(new Rover(new Location(initialPosition, initialOrientation, world),
                signalsToCommands), rover);
    }
}
