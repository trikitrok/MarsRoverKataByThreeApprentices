package rover.commands;

import rover.Location;

public class RotateRight implements Command {

    @Override
    public Location apply(Location location) {
        return location.rotateRight();
    }
}
