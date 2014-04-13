package tests.rover;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static rover.location.Orientation.NORTH;
import static tests.rover.RoverBuilder.aRover;

import org.junit.Test;

import rover.Rover;
import rover.World;
import rover.location.Position;

public class InSphericalWorld {

    @Test
    public void hasItsPositionWrapped() {
        World world = mock(World.class);
        Rover rover = aRover().at(0, 1).facing(NORTH).in(world).build();

        rover.receive("f");

        verify(world, times(1)).wrap(any(Position.class));
    }
}
