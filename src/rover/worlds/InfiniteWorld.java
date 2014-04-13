package rover.worlds;

import rover.World;
import rover.location.Position;

public class InfiniteWorld implements World {

    @Override
    public Position wrap(Position tentativePosition) {
        return tentativePosition;
    }

    @Override
    public boolean hasObstacleAt(Position position) {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "InfiniteWorld";
    }
}
