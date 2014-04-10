package tests.rover;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import rover.Location;
import rover.Rover;
import rover.World;
import rover.location.Orientation;
import rover.location.Position;

public class InSphericalWorld {

    @Test
    public void hasItsPositionWrapped() {
        World world = mock(World.class);
        Rover rover = new Rover(new Location(new Position(0, 1), Orientation.NORTH, world));

        rover.receive("f");

        verify(world, times(1)).wrap(any(Position.class));
    }
}
