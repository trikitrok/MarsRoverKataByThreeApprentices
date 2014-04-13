package tests;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import rover.Location;
import rover.Rover;
import rover.World;
import rover.location.Orientation;
import rover.location.Position;

public class MatchersFactory {
    public static Matcher<Rover> isLocatedAt(final int x, final int y,
            final Orientation orientation, final World world) {

        return new BaseMatcher<Rover>() {
            @Override
            public boolean matches(final Object item) {
                final Rover rover = (Rover) item;
                return rover.at(new Location(new Position(x, y), orientation, world));
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Rover should be at ").appendValue(
                        new Location(new Position(x, y), orientation, world));
            }
        };
    }

    public static Matcher<Rover> isLocatedAt(final Position position,
            final Orientation orientation, final World world) {

        return new BaseMatcher<Rover>() {
            @Override
            public boolean matches(final Object item) {
                final Rover rover = (Rover) item;
                return rover.at(new Location(position, orientation, world));
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Rover should be at ").appendValue(
                        new Location(position, orientation, world));
            }
        };
    }
}