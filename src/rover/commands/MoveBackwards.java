package rover.commands;

import rover.Command;
import rover.Location;
import rover.ObstacleFoundException;
import rover.Position;
import rover.World;

public class MoveBackwards implements Command {

    private World world;

    public MoveBackwards(World world) {
        this.world = world;
    }

    @Override
    public Location apply(Location location) {
        Position tentativePosition = location.getOrientation().move(-1, location.getPosition());

        if (world.hasObstacleAt(tentativePosition)) {
            throw new ObstacleFoundException();
        }
        return new Location(world.wrap(tentativePosition), location.getOrientation());
    }
}
