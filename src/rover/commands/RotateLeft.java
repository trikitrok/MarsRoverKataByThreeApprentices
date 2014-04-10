package rover.commands;

import rover.Location;

public class RotateLeft implements Command {

    @Override
    public Location apply(Location location) {
        return location.rotateLeft();
    }
}
