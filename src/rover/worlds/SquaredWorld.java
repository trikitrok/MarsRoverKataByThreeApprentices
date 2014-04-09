package rover.worlds;

import rover.Obstacles;
import rover.Position;
import rover.World;

public class SquaredWorld implements World {

    private int side;
    private Obstacles obstacles;

    public SquaredWorld(int side) {
        this(side, new Obstacles());
    }

    public SquaredWorld(int side, Obstacles obstacles) {
        this.side = side;
        this.obstacles = obstacles;
    }

    @Override
    public Position wrap(Position tentativePosition) {
        return new Position((tentativePosition.getX() + side) % side,
                (tentativePosition.getY() + side) % side);
    }

    @Override
    public boolean hasObstacleAt(Position position) {
        return obstacles.obstacleAt(position);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((obstacles == null) ? 0 : obstacles.hashCode());
        result = prime * result + side;
        return result;
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

}
