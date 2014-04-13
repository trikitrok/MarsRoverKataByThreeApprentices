package tests.rover;

import static tests.RoverBuilder.aRover;
import static rover.location.Orientation.*;
import static tests.MatchersFactory.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import rover.Rover;
import rover.worlds.InfiniteWorld;

public class ReceivingSeveralCommands {

    @Test
    public void processesThem() {
        Rover rover = aRover().at(0, 0).facing(NORTH).in(new InfiniteWorld()).build();

        rover.receive("bl");

        assertThat(rover, isLocatedAt(0, -1, WEST, new InfiniteWorld()));
    }
}
