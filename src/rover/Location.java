package rover;

import rover.location.Orientation;
import rover.location.Position;
import rover.worlds.ObstacleFoundException;

public class Location {

    private Position position;
    private Orientation orientation;
    private World world;

    public Location(Position position, Orientation orientation, World world) {
        this.position = position;
        this.orientation = orientation;
        this.world = world;
    }

    public Location displace(int displacement) {
        Position tentativePosition = this.orientation.move(displacement, this.position);

        if (this.world.hasObstacleAt(tentativePosition)) {
            throw new ObstacleFoundException();
        }

        Position newPosition = this.world.wrap(tentativePosition);

        return new Location(newPosition, this.orientation, this.world);
    }

    public Location rotateLeft() {
        return new Location(this.position, this.orientation.rotateLeft(), this.world);
    }

    public Location rotateRight() {
        return new Location(this.position, this.orientation.rotateRight(), this.world);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        if (orientation != other.orientation)
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        if (world == null) {
            if (other.world != null)
                return false;
        } else if (!world.equals(other.world))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Location [position=" + position + ", orientation=" + orientation + ", world="
                + world + "]";
    }

}
