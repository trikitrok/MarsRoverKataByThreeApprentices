package tests.rover;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import rover.Location;
import rover.Rover;
import rover.SignalsToCommandsTable;
import rover.location.Orientation;
import rover.location.Position;
import rover.worlds.InfiniteWorld;

public class ReceivingSeveralCommands {

    @Test
    public void processesThem() {
        SignalsToCommandsTable signalsToCommands = new SignalsToCommandsTable();
        Rover rover = new Rover(new Location(new Position(0, 0), Orientation.NORTH,
                new InfiniteWorld()), signalsToCommands);

        rover.receive("bl");

        assertTrue(rover
                .at(new Location(new Position(0, -1), Orientation.WEST, new InfiniteWorld())));
    }
}
