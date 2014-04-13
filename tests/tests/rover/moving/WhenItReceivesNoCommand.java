package tests.rover.moving;

import static org.junit.Assert.assertTrue;
import static tests.rover.RoverBuilder.aRover;

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
        Rover rover = aRover().at(1, 0).in(new InfiniteWorld()).facing(Orientation.SOUTH).build();

        rover.receive("");

        assertTrue(rover
                .at(new Location(new Position(1, 0), Orientation.SOUTH, new InfiniteWorld())));
    }
}
