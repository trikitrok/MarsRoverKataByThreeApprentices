package rover;

import rover.location.Position;

public interface World {

    public Position wrap(Position tentativePosition);

    public boolean hasObstacleAt(Position position);
}
