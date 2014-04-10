package rover.commands;

import rover.Location;

public class Move implements Command {

    private int displacement;

    public Move(int displacement) {
        super();
        this.displacement = displacement;
    }

    @Override
    public Location apply(Location location) {
        return location.displace(displacement);
    }
}
