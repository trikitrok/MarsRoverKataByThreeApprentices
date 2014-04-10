package tests.rover;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rover.Rover;
import rover.location.Orientation;
import rover.location.Position;
import rover.worlds.InfiniteWorld;

public class ReceivingSeveralCommands {

    @Test
    public void processesThem() {
        Rover rover = new Rover(new Position(0, 0), Orientation.NORTH, new InfiniteWorld());

        rover.receive("bl");

        assertEquals(new Rover(new Position(0, -1), Orientation.WEST, new InfiniteWorld()), rover);
    }
}
