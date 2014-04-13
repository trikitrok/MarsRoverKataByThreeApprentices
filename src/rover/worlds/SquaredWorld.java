package rover.worlds;

import rover.World;
import rover.location.Position;

public class SquaredWorld implements World {

    private int side;
    private Obstacles obstacles;

    public SquaredWorld(int side, Obstacles obstacles) {
        this.side = side;
        this.obstacles = obstacles;
    }

    @Override
    public Position wrap(Position position) {
        return new Position((position.x() + side) % side, (position.y() + side) % side);
    }

    @Override
    public boolean hasObstacleAt(Position position) {
        return obstacles.obstacleAt(position);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SquaredWorld other = (SquaredWorld) obj;
        if (obstacles == null) {
            if (other.obstacles != null)
                return false;
        } else if (!obstacles.equals(other.obstacles))
            return false;
        if (side != other.side)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SquaredWorld [side=" + side + ", obstacles=" + obstacles + "]";
    }
}
