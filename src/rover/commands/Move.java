package rover.commands;

import rover.Command;
import rover.Location;
import rover.ObstacleFoundException;
import rover.Position;
import rover.World;

public class Move implements Command {

    private World world;
    private int displacement;

    public Move(World world, int displacement) {
        super();
        this.world = world;
        this.displacement = displacement;
    }

    @Override
    public Location apply(Location location) {
        Position tentativePosition = location.getOrientation().move(displacement,
                location.getPosition());

        if (world.hasObstacleAt(tentativePosition)) {
            throw new ObstacleFoundException();
        }

        return new Location(world.wrap(tentativePosition), location.getOrientation());
    }
}