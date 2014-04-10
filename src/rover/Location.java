package rover;

import rover.location.Orientation;
import rover.location.Position;

public class Location {

    private Position position;
    private Orientation orientation;

    public Location(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public Position getPosition() {
        return position;
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
        return true;
    }
}
