package tests.rover;

import static org.junit.Assert.assertTrue;
import static tests.rover.RoverBuilder.aRover;
import static rover.location.Orientation.*;

import org.junit.Test;

import rover.Location;
import rover.Rover;
import rover.location.Position;
import rover.worlds.InfiniteWorld;

public class ReceivingSeveralCommands {

    @Test
    public void processesThem() {
        Rover rover = aRover().at(0, 0).facing(NORTH).in(new InfiniteWorld()).build();

        rover.receive("bl");

        assertTrue(rover.at(new Location(new Position(0, -1), WEST, new InfiniteWorld())));
    }
}
