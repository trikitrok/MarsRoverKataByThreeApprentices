package rover.commands;

import rover.Location;

public class RotateRight implements Command {

    @Override
    public Location apply(Location location) {
        return new Location(location.getPosition(), location.getOrientation().rotateRight());
    }
}
