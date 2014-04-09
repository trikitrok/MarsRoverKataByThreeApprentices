package tests.rover;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import rover.Orientation;
import rover.Position;
import rover.Rover;
import rover.World;

public class InSphericalWorld {

    @Test
    public void hasItsPositionWrapped() {
        World world = mock(World.class);
        Rover rover = new Rover(new Position(0, 1), Orientation.NORTH, world);

        rover.receive("f");

        verify(world, times(1)).wrap(any(Position.class));
    }
}
