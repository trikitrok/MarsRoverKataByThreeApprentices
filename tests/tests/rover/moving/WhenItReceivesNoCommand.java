package tests.rover.moving;

import static org.hamcrest.MatcherAssert.assertThat;
import static rover.location.Orientation.SOUTH;
import static tests.MatchersFactory.isLocatedAt;
import static tests.RoverBuilder.aRover;

import org.junit.Test;

import rover.Rover;
import rover.worlds.InfiniteWorld;

public class WhenItReceivesNoCommand {

    @Test
    public void staysAtInitialPosition() {
        Rover rover = aRover().at(1, 0).in(new InfiniteWorld()).facing(SOUTH).build();

        rover.receive("");

        assertThat(rover, isLocatedAt(1, 0, SOUTH, new InfiniteWorld()));
    }
}
