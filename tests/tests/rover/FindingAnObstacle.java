package tests.rover;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import rover.Location;
import rover.Rover;
import rover.World;
import rover.location.Orientation;
import rover.location.Position;
import rover.worlds.ObstacleFoundException;

public class FindingAnObstacle {

    @Test(expected = ObstacleFoundException.class)
    public void throwsAnException() {
        rover.receive("f");
    }

    @Test
    public void doesNotMoveAnyMore() {
        try {
            rover.receive("f");
        } catch (ObstacleFoundException e) {
            assertEquals(new Rover(new Location(initialPosition, initialOrientation, stubWorld)),
                    rover);
        }
    }

    @Before
    public void setUp() {
        initialPosition = new Position(0, 0);
        initialOrientation = Orientation.NORTH;

        stubWorld = mock(World.class);
        when(stubWorld.hasObstacleAt(any(Position.class))).thenReturn(true);

        rover = new Rover(new Location(initialPosition, initialOrientation, stubWorld));
    }

    private World stubWorld;
    private Rover rover;
    private Position initialPosition;
    private Orientation initialOrientation;
}
