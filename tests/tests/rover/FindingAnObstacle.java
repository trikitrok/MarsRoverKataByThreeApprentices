package tests.rover;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static tests.rover.RoverBuilder.aRover;

import org.junit.Before;
import org.junit.Test;

import rover.Location;
import rover.Rover;
import rover.World;
import rover.location.Orientation;
import rover.location.Position;
import rover.worlds.ObstacleFoundException;

public class FindingAnObstacle {

    private Rover rover;
    private World stubWorld;
    private Position initialPosition;
    private Orientation initialOrientation;

    @Before
    public void setUp() {
        initialPosition = new Position(0, 0);
        initialOrientation = Orientation.NORTH;

        stubWorld = mock(World.class);
        when(stubWorld.hasObstacleAt(any(Position.class))).thenReturn(true);

        rover = aRover().at(initialPosition).in(stubWorld).facing(initialOrientation).build();
    }

    @Test(expected = ObstacleFoundException.class)
    public void throwsAnException() {
        rover.receive("f");
    }

    @Test
    public void doesNotMoveAnyMore() {
        try {
            rover.receive("f");
        } catch (ObstacleFoundException e) {
            assertTrue(rover.at(new Location(initialPosition, initialOrientation, stubWorld)));
        }
    }
}
