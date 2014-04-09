package rover.commands;

import rover.Command;
import rover.Location;
import rover.ObstacleFoundException;
import rover.Position;
import rover.World;

public class MoveForwards implements Command {
    private World world;

    public MoveForwards(World world) {
        super();
        this.world = world;
    }

    @Override
    public Location apply(Location location) {
        Position tentativePosition = location.getOrientation().move(1, location.getPosition());

        if (world.hasObstacleAt(tentativePosition)) {
            throw new ObstacleFoundException();
        }
        return new Location(world.wrap(tentativePosition), location.getOrientation());
    }
}
