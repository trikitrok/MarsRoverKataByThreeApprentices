package rover.commands;

import rover.Command;
import rover.Location;

public class RotateLeft implements Command {

    @Override
    public Location apply(Location location) {
        return new Location(location.getPosition(), location.getOrientation().rotateLeft());
    }

}
