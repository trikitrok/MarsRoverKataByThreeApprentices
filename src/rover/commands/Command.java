package rover.commands;

import rover.Location;

public interface Command {
    public Location apply(Location location);
}
