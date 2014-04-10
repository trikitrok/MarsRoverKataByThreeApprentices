package tests.rover.moving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rover.Rover;
import rover.World;
import rover.location.Orientation;
import rover.location.Position;
import rover.worlds.InfiniteWorld;

public class WhenItReceivesNoCommand {

	@Test
	public void staysAtInitialPosition() {
		World world = new InfiniteWorld();
		Position initialPosition = new Position(1, 0);
		Orientation initialOrientation = Orientation.SOUTH;
		Rover rover = new Rover(initialPosition, initialOrientation, world);

		rover.receive("");

		assertEquals(new Rover(initialPosition, initialOrientation, world),
				rover);
	}
}
