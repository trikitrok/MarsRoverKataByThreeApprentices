package tests.rover.moving;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import rover.Orientation;
import rover.Position;
import rover.Rover;
import rover.World;
import rover.worlds.InfiniteWorld;

public class WhenFacingWest {

	@Test
	public void forwards() {
		rover.receive("f");

		assertEquals(new Rover(new Position(4, 5), Orientation.WEST, world),
				rover);
	}

	@Test
	public void backwards() {
		rover.receive("b");

		assertEquals(new Rover(new Position(6, 5), Orientation.WEST, world),
				rover);
	}

	private Rover rover;
	private World world;

	@Before
	public void setUp() {
		world = new InfiniteWorld();
		rover = new Rover(new Position(5, 5), Orientation.WEST, world);
	}
}
